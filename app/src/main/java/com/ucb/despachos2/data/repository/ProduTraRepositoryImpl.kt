package com.ucb.despachos2.data.repository

import com.ucb.despachos2.data.local.AuthPreferences
import com.ucb.despachos2.data.model.ProduccionTransporte.Entrega
import com.ucb.despachos2.data.model.ProduccionTransporte.ProduTraResponse
import com.ucb.despachos2.data.remote.ProduTransApi
import com.ucb.despachos2.domain.repository.ProduTraRespository
import javax.inject.Inject

class ProduTraRepositoryImpl @Inject constructor(
    private val apiService: ProduTransApi,
    private val authPreferences: AuthPreferences
): ProduTraRespository {
    override suspend fun obtenerProductosPorTransporte(fecha: String): List<Entrega> {
        val token = authPreferences.getToken()?: throw Exception ("Token no disponible")
        return apiService.getProductosPorTransporte("Bearer $token" , fecha)
    }
}