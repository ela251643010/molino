package com.ucb.despachos2.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.despachos2.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) :ViewModel(){
    private val _loginState = MutableLiveData<Result<String>>()
    val loginState: LiveData<Result<String>> = _loginState

    fun login ( username : String, password: String){
        viewModelScope.launch {
            _loginState.value = authRepository.login(username,password)
        }
    }
}