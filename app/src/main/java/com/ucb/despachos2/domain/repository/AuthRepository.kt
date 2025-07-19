package com.ucb.despachos2.domain.repository

import androidx.compose.ui.input.pointer.PointerEventPass

interface AuthRepository {
    suspend fun login (username: String, password: String ): Result<String>
}