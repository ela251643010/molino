package com.ucb.despachos2.data.local

import android.content.Context
import javax.inject.Inject

class AuthPreferences @Inject constructor(
    context:Context
) {
    private val sharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveToken(token:String){
        sharedPreferences.edit().putString("auth_token", token).apply()
    }
    fun getToken():String?{
        return sharedPreferences.getString("auth_token", null)
    }
    fun clearToken(){
        sharedPreferences.edit().remove("auth_token").apply()
    }
}