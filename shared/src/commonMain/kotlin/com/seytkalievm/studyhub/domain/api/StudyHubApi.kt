package com.seytkalievm.studyhub.domain.api

import com.seytkalievm.studyhub.domain.model.Deck

interface StudyHubApi {

    suspend fun getAllDecks(token: String) : List<Deck>
}