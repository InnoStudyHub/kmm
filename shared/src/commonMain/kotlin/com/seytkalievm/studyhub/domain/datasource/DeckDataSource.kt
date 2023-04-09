package com.seytkalievm.studyhub.domain.datasource

import com.seytkalievm.studyhub.domain.model.Deck

interface DeckDataSource {
    suspend fun getPopularDecks(): List<Deck>
}