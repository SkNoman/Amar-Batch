package com.example.amarbatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amarbatch.ui.Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.Theme_AmarBatch)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = Login()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,login)
            commit()
        }
    }
}