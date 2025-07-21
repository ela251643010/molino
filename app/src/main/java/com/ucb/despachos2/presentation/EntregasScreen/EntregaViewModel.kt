package com.ucb.despachos2.presentation.EntregasScreen

import android.media.session.MediaSession.Token
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ucb.despachos2.data.model.despachos.EntregaResponse
import com.ucb.despachos2.data.model.despachos.FechaRequest
import com.ucb.despachos2.data.repository.EntregaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EntregaViewModel @Inject constructor(
    private val entregaRepository: EntregaRepository
):ViewModel() {
    private val _entregas = MutableLiveData<Result<List<EntregaResponse>>>()
    val entregas: LiveData<Result<List<EntregaResponse>>> = _entregas

    fun cargarEntregas(fecha : String){
        viewModelScope.launch {
            _entregas.value = entregaRepository.obtenerEntregas(fecha)
        }
    }
}