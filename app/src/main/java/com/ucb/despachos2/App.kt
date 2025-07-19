package com.ucb.despachos2

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            Log.d("AppDebug", "App initialized")
        } catch (e: Exception) {
            Log.e("AppDebug", "Falla en App.kt: ${e.message}", e)
        }
    }

}