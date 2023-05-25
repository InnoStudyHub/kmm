package com.seytkalievm.studyhub.domain.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.seytkalievm.studyhub.domain.Const.ApiKey
import com.seytkalievm.studyhub.domain.Const.BaseUrl
import com.seytkalievm.studyhub.domain.StudyHubHttpClient
import com.seytkalievm.studyhub.domain.api.AuthApi
import com.seytkalievm.studyhub.domain.model.Token
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AuthRepository(private val dataStore: DataStore<Preferences>) : AuthApi {

    private val httpClient = StudyHubHttpClient.getHttpClient()
    private val accessToken = stringPreferencesKey("access")
    private val refreshToken = stringPreferencesKey("refresh")

    override suspend fun login(email: String, password: String): Token {
        val response = httpClient.post("$BaseUrl/auth/login/") {

            header("X-API-KEY", ApiKey)
            header("Content-Type", "application/json")
            header("Origin", "http://studyhub.kz")
            header("Accept", "*/*")
            setBody(Json.encodeToString(mapOf("email" to email, "password" to password)))
        }

        val token = response.body<Token>()
        dataStore.edit {preferences ->
            preferences[accessToken] = token.access
            preferences[refreshToken] = token.refresh
        }

        return token
    }

    override suspend fun refreshAccessToken(): String {
        val token = dataStore.data.map {
            it[refreshToken] ?: error("Refresh token is expected, but got null")
        }.first()

        val response = httpClient.post("$BaseUrl/auth/login/refresh/") {

            header("X-API-KEY", ApiKey)
            header("Content-Type", "application/json")
            header("Origin", "http://studyhub.kz")
            header("Accept", "*/*")
            setBody(Json.encodeToString(mapOf("refresh" to token)))
        }
        val access = response.body<Map<String, String>>()["access"] ?: error("Didn't get token")
        dataStore.edit { preferences ->
            preferences[accessToken] = access
        }

        return access
    }
}
