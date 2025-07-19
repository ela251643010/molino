package com.ucb.despachos2.data.model

data class LoginRequest(
    val id: Int,
    val username: String,
    val password: String,
    val state: String,
    val establecimiento: Establecimiento
) {
}
data class Establecimiento(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val estado: String

)