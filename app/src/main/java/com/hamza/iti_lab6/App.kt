package com.hamza.iti_lab6

import android.app.Application
import com.hamza.iti_lab6.utils.MySharedPreferences

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MySharedPreferences.init(this)
    }
}