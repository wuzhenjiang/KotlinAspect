package com.okay.kotlinaspect

import android.util.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

@Aspect
class PerformanceAspect {
 
    companion object {
        val TAG = PerformanceAspect::class.java.simpleName
    }
 
    @Pointcut("execution(@com.okay.kotlinaspect.CheckNet * *(..))")
    fun performancePointcut() {
    }
 
    @Around("performancePointcut()")
    @Throws(Throwable::class)
    fun measureMethodTime(joinPoint: ProceedingJoinPoint) {
        val signature = joinPoint.signature as MethodSignature
        val thisAny = joinPoint.`this`
        val className = thisAny.javaClass.simpleName
        val methodName = signature.method.name
        val start = System.currentTimeMillis()
        joinPoint.proceed()
        val duration = System.currentTimeMillis() - start
        Log.e(TAG, "$className.$methodName 耗时：${duration}ms")
    }
}

