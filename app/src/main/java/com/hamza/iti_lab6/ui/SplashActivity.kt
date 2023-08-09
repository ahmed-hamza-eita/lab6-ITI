package com.hamza.iti_lab6.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hamza.iti_lab6.R
import com.hamza.iti_lab6.utils.MySharedPreferences

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        checkIfUserLoggedIn()
        setContentView(R.layout.activity_splash)
    }

    private fun checkIfUserLoggedIn() {
         if(MySharedPreferences.getUserEmail().isEmpty()){
             startActivity(Intent(this,LoginActivity::class.java))
         }
        else {
             startActivity(Intent(this,MainActivity::class.java))

         }
    }


}