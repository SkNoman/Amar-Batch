package com.example.amarbatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.amarbatch.ui.Login


var token = ""
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