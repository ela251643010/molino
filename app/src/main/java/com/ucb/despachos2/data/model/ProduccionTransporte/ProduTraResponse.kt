package com.ucb.despachos2.data.model.ProduccionTransporte

import com.ucb.despachos2.data.model.Establecimiento
import okhttp3.internal.platform.BouncyCastlePlatform
import org.intellij.lang.annotations.JdkConstants.TitledBorderTitlePosition

data class ProduTraResponse(
    val id: Int,
    val nombre: String,
    val comentario: String,
    val estado :String,
    val tipo: Tipo,
    val facprn: Int,
    val orden: Int
)
data class Tipo(
    val id: Int,
    val nombre:String
)
data class Transporte(
    val id: Long?,
    val fecha: Long?,
    val conductor:String,
    val comentario: String,
    val placa:String,
    val estado:String,
    val tipo: String,
    val cantidad: Int?,
    val establecimiento: Establecimiento
)
data class Entrega(
    val cantidad: Double?,
    val notatipo: String,
    val producto: ProduTraResponse,
    val transporte: Transporte
)
