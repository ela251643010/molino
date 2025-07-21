package com.ucb.despachos2.data.model.despachos

data class FechaRequest(
    val id: Int = 0,
    val sid: Int = 0,
    val str: String = "",
    val sstr: String = "",
    val dec: Int =0,
    val sdec: Int = 0,
    val date: String,
    val sdate: String,
    val orderby: List<String> = listOf("tr.id"),
    val limit: Int = 0,
    val offset:Int = 0
)
