package com.seytkalievm.studyhub.domain.api

import com.seytkalievm.studyhub.domain.model.Token

interface AuthApi {

    suspend fun login(email: String, password: String): Token

    suspend fun refreshAccessToken(): String
}