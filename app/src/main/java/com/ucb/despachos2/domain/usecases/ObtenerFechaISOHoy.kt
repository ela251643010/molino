package com.ucb.despachos2.domain.usecases

import java.text.SimpleDateFormat
import java.util.*

fun obtenerFechaISOHoy(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return formatter.format(Date())
}
fun formatearFechaParaApiBolivia(fecha: Date): String {
    val boliviaTimeZone = TimeZone.getTimeZone("America/La_Paz")
    val formatter = SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH)
    formatter.timeZone = boliviaTimeZone
    return formatter.format(fecha) + " (hora de Bolivia)"
}
fun formatearFechaStringParaApiBolivia(fechaStr: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        inputFormat.timeZone = TimeZone.getTimeZone("America/La_Paz")
        val date = inputFormat.parse(fechaStr)

        val outputFormat = SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH)
        outputFormat.timeZone = TimeZone.getTimeZone("America/La_Paz")

        outputFormat.format(date!!) + " (hora de Bolivia)"
    } catch (e: Exception) {
        "Invalid Date"
    }
}
