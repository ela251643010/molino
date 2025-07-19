package com.ucb.despachos2.data.remote

import com.ucb.despachos2.data.model.LoginRequest
import com.ucb.despachos2.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST ("/login")
    suspend fun login(@Body request: LoginRequest): Response<Unit>

}