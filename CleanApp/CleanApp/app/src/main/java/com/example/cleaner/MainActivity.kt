package com.example.cleaner

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val n = cleanBackground(this)
        Toast.makeText(this, "已清理 $n 个应用的后台", Toast.LENGTH_SHORT).show()
        finish()
    }
}
