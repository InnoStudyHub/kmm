package com.seytkalievm.studyhub.domain.api

import kotlinx.coroutines.flow.Flow

interface AuthApi {

    suspend fun login(email: String, password: String)

    suspend fun refreshAccessToken(): String

    suspend fun logout()

    val isLoggedIn: Flow<Boolean>
}