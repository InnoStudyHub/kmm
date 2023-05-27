package com.seytkalievm.studyhub.domain.api

interface AuthApi {

    suspend fun login(email: String, password: String)

    suspend fun refreshAccessToken(): String

    suspend fun logout()

    suspend fun isLoggedIn(): Boolean
}