package com.seytkalievm.studyhub.domain.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.seytkalievm.studyhub.domain.Const.ApiKey
import com.seytkalievm.studyhub.domain.Const.BaseUrl
import com.seytkalievm.studyhub.domain.StudyHubHttpClient
import com.seytkalievm.studyhub.domain.api.StudyHubApi
import com.seytkalievm.studyhub.domain.model.Deck
import com.seytkalievm.studyhub.domain.model.SearchResult
import io.ktor.client.call.*
import io.ktor.client.request.post
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class StudyHubRepository(private val dataStore: DataStore<Preferences>) : StudyHubApi {

    private val httpClient = StudyHubHttpClient.getHttpClient()

    override suspend fun getAllDecks(): List<Deck> {

        val token = dataStore.data.map { it[stringPreferencesKey("access")] }.first()

        try {
            val response = httpClient.post("$BaseUrl/user/search/") {

                header("X-API-KEY", ApiKey)
                header("Content-Type", "application/json")
                header("Origin", "http://studyhub.kz")
                header("Accept", "*/*")
                header("Authorization", "Bearer $token")
                setBody(Json.encodeToString("query" to ""))
            }

            val result: SearchResult = response.body()

            return result.decks
        } catch (e: Exception) {
            println(e.message)
            throw (e)
        }
    }

    override suspend fun searchDecks(query: String): List<Deck> {
        val token = dataStore.data.map { it[stringPreferencesKey("access")] }.first()

        try {
            val response = httpClient.post("$BaseUrl/user/search/") {

                header("X-API-KEY", ApiKey)
                header("Content-Type", "application/json")
                header("Origin", "http://studyhub.kz")
                header("Accept", "*/*")
                header("Authorization", "Bearer $token")
                setBody(Json.encodeToString("query" to query))
            }

            val result: SearchResult = response.body()

            return result.decks
        } catch (e: Exception) {
            println(e.message)
            throw (e)
        }
    }
}
