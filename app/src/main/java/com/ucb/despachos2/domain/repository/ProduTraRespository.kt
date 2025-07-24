package com.ucb.despachos2.domain.repository

import com.ucb.despachos2.data.model.ProduccionTransporte.Entrega
import com.ucb.despachos2.data.model.ProduccionTransporte.ProduTraResponse
import com.ucb.despachos2.data.remote.ProduTransApi
import javax.inject.Inject

interface ProduTraRespository {
    suspend fun obtenerProductosPorTransporte( fecha: String): List<Entrega>
}