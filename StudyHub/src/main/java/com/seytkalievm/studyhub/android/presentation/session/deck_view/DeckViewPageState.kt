package com.seytkalievm.studyhub.android.presentation.session.deck_view

import com.seytkalievm.studyhub.domain.model.Deck

data class DeckViewPageState (
    val decks: List<Deck> = emptyList()
)