package com.seytkalievm.studyhub.domain.api

import com.seytkalievm.studyhub.domain.model.Deck

interface StudyHubApi {

    suspend fun getAllDecks() : List<Deck>

    suspend fun searchDecks(query: String) : List<Deck>
}