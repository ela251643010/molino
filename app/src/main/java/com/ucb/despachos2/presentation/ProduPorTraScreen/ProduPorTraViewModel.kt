package com.ucb.despachos2.presentation.ProduPorTraScreen


import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.despachos2.data.model.ProduccionTransporte.Entrega
import com.ucb.despachos2.data.model.ProduccionTransporte.ProduTraResponse
import com.ucb.despachos2.domain.usecases.ObtenerProductosPorTransporte
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProduPorTraViewModel @Inject constructor(
    private val obtenerProductosPorTransporte: ObtenerProductosPorTransporte
): ViewModel(){

    private val _entregas = MutableLiveData<List<Entrega>>()
    val entregas: LiveData<List<Entrega>> get () = _entregas

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> get ()= _error

    fun cargarProduPorTransporte(fecha: String){
        viewModelScope.launch {
            try {
                val result = obtenerProductosPorTransporte(fecha)
                _entregas.value = result
            }catch (e: Exception){
                _error.value = "Error  al cargar entregas: ${e.message}"
            }
        }
    }
}