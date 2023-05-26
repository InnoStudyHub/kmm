package com.seytkalievm.studyhub.domain

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private var httpClient: HttpClient? = null

object StudyHubHttpClient {

    fun getHttpClient(): HttpClient {
        if (httpClient == null) {
            httpClient = HttpClient {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                    })
                }
            }
        }
        return httpClient!!
    }
}