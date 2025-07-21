package com.ucb.despachos2.data.remote

import android.media.session.MediaSession.Token
import com.ucb.despachos2.data.model.despachos.EntregaResponse
import com.ucb.despachos2.data.model.despachos.FechaRequest

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.Response

interface EntregaApi {
    @POST ("/ventas/ventaagalpon/r/transporte")
    suspend fun getEntregas(
        @Header("Authorization") token: String,
        @Body request: FechaRequest
    ): Response<List<EntregaResponse>>
}