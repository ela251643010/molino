package com.ucb.despachos2.data.remote

import com.ucb.despachos2.data.model.ProduccionTransporte.Entrega
import com.ucb.despachos2.data.model.ProduccionTransporte.ProduTraResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ProduTransApi {
    @GET("/ventas/ventaagalpon/r/transproddia")
    suspend fun getProductosPorTransporte(
        @Header("Authorization") token: String,
        @Query("date") fecha: String
    ): List<Entrega>
}