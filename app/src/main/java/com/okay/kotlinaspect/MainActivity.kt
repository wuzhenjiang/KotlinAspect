package com.okay.kotlinaspect

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @CheckNet
    fun click(view: View) {
        Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show()
    }
}