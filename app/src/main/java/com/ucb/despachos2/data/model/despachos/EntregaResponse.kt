package com.ucb.despachos2.data.model.despachos

import com.ucb.despachos2.data.model.Establecimiento

data class EntregaResponse(
    val id: Int,
    val fecha : Long,
    val conductor : String,
    val comentario : String,
    val placa : String,
    val estado : String,
    val tipo: String,
    val cantidad: Double,
    val establecimiento: Establecimiento
)
