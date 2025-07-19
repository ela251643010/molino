package com.ucb.despachos2.di

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("AppDebug", "App initialized") // 👈 Esto debería salir en logcat
    }
}