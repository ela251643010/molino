package com.ucb.despachos2.presentation.ProduPorTraScreen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucb.despachos2.data.model.ProduccionTransporte.Entrega

@Composable
fun ProduPorTraUi(viewModel: ProduPorTraViewModel = hiltViewModel()) {
    val entregas by viewModel.entregas.observeAsState(emptyList())
    val error by viewModel.error.observeAsState()
    var fecha by remember { mutableStateOf("Wed Jun 04 2025 00:00:00 GMT-0400 (hora de Bolivia)") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Producción por Transporte", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha (yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.cargarProduPorTransporte(fecha) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text("⚠️ ${error}", color = MaterialTheme.colorScheme.error)
        }

        if (entregas.isNotEmpty()) {
            TableHeader()
            LazyColumn {
                items(entregas) { Entrega ->
                    TableRow(Entrega)
                }
            }
        } else {
            Text("No hay datos para la fecha seleccionada")
        }
    }
}
@Composable
fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Transporte", modifier = Modifier.weight(1f), style = MaterialTheme.typography.labelLarge)
        Text("Producto", modifier = Modifier.weight(1f), style = MaterialTheme.typography.labelLarge)
        Text("Cantidad", modifier = Modifier.weight(1f), style = MaterialTheme.typography.labelLarge)
    }
    Divider()
}

@Composable
fun TableRow(entrega: Entrega) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(entrega.transporte.conductor, modifier = Modifier.weight(1f))
        Text(entrega.producto.nombre, modifier = Modifier.weight(1f))
        Text(entrega.cantidad?.toString() ?: "-", modifier = Modifier.weight(1f))

    }
    Divider()
}
