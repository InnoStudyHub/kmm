package com.seytkalievm.studyhub.domain.repository

import com.seytkalievm.studyhub.domain.Const.ApiKey
import com.seytkalievm.studyhub.domain.Const.BaseUrl
import com.seytkalievm.studyhub.domain.StudyHubHttpClient
import com.seytkalievm.studyhub.domain.api.AuthApi
import com.seytkalievm.studyhub.domain.model.Token
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AuthRepository : AuthApi {

    private val httpClient = StudyHubHttpClient.getHttpClient()

    override suspend fun login(email: String, password: String): Token {
        val response = httpClient.post("$BaseUrl/auth/login/") {

            header("X-API-KEY", ApiKey)
            header("Content-Type", "application/json")
            header("Origin", "http://studyhub.kz")
            header("Accept", "*/*")
            setBody(Json.encodeToString(mapOf("email" to email, "password" to password)))
        }

        return response.body()
    }

    override suspend fun refreshToken(refreshToken: String): String {
        return ""
    }
}
