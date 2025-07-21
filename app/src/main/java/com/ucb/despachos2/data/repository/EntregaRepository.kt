package com.ucb.despachos2.data.repository

import com.ucb.despachos2.data.local.AuthPreferences
import com.ucb.despachos2.data.model.despachos.EntregaResponse
import com.ucb.despachos2.data.model.despachos.FechaRequest
import com.ucb.despachos2.data.remote.EntregaApi
import retrofit2.Response
import javax.inject.Inject

class EntregaRepository @Inject constructor(
    private val api: EntregaApi,
    private val authPreferences: AuthPreferences
) {
    suspend fun obtenerEntregas(fecha: String):Result<List<EntregaResponse>>
    {
        return try{
            val token = authPreferences.getToken()
                ?: return    Result.failure(Exception("Token no disponible"))
            val request = FechaRequest(
                date= fecha,
                sdate = fecha
            )
            val response = api.getEntregas("Bearer $token",request)
            if(response.isSuccessful){
                Result.success(response.body()?: emptyList())
            } else{
                Result.failure(Exception("Error ${response.code()}: ${response.message()}"))
            }
        }catch (e:Exception)
        {
            Result.failure(e)
        }
    }
}