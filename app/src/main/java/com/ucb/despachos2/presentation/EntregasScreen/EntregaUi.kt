package com.ucb.despachos2.presentation.EntregasScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry

@Composable
fun EntregaUi(backStackEntry: NavBackStackEntry) {
    //val context = LocalContext.current
    val viewModel : EntregaViewModel = hiltViewModel(backStackEntry)
    val entregasResult by viewModel.entregas.observeAsState()

    LaunchedEffect(Unit) {
        /*
        val today = obtenerFechaISOHoy()
        viewModel.cargarEntregas(today)*/
        viewModel.cargarEntregas("2025-06-10T20:01:05.447Z")
    }

    when {
        entregasResult == null -> {
            Text("Cargando entregas...")
        }
        entregasResult?.isSuccess == true -> {
            val entregas = entregasResult?.getOrNull() ?: emptyList()
            LazyColumn {
                items(entregas.size) { index ->
                    val entrega = entregas[index]
                    Text("Fecha: ${entrega.fecha}")
                    Text("Conductor: ${entrega.conductor}")
                    Text("Cantidad: ${entrega.cantidad}")
                    Divider()
                }
            }
        }
        entregasResult?.isFailure == true -> {
            val error = entregasResult?.exceptionOrNull()
            Text("Error: ${error?.message}")
        }
    }
}
