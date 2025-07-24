package com.ucb.despachos2.domain.usecases

import com.ucb.despachos2.data.model.ProduccionTransporte.Entrega
import com.ucb.despachos2.data.model.ProduccionTransporte.ProduTraResponse
import com.ucb.despachos2.data.repository.EntregaRepository
import com.ucb.despachos2.data.repository.ProduTraRepositoryImpl
import com.ucb.despachos2.domain.repository.ProduTraRespository
import javax.inject.Inject

class ObtenerProductosPorTransporte @Inject constructor(
    private val repository: ProduTraRepositoryImpl
) {
    suspend operator fun invoke(fecha:String): List<Entrega>{
        return repository.obtenerProductosPorTransporte(fecha)
    }
}