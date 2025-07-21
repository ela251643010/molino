package com.ucb.despachos2.data.repository

import com.ucb.despachos2.data.local.AuthPreferences
import com.ucb.despachos2.data.model.Establecimiento
import com.ucb.despachos2.data.model.LoginRequest
import com.ucb.despachos2.data.remote.AuthApi
import com.ucb.despachos2.domain.repository.AuthRepository
import javax.inject.Inject
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val authPreferences: AuthPreferences
) : AuthRepository {

    override suspend fun login(username: String, password: String): Result<String> {
        return try {
            val request = LoginRequest(
                id = 0,
                username = username,
                password = password,
                state = "ACTIVO",
                establecimiento = Establecimiento(
                    id = 1,
                    nombre = "MOLINO",
                    descripcion = "ESTABLECIMIENTO PRINCIPAL",
                    estado = "ACTIVO"
                )
            )

            val response = api.login(request)

            if (response.isSuccessful) {
               val token = response.headers()["Authorization"]?.removePrefix("Bearer ") ?: ""
                authPreferences.saveToken(token)
                Result.success(token)
            } else {
                Result.failure(Exception("Error ${response.code()}: ${response.message()}"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
