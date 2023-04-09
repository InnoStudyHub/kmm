package com.seytkalievm.studyhub.android.presentation.session.home

import com.seytkalievm.studyhub.domain.model.Deck

data class HomePageState (
    val decks: List<Deck> = emptyList()
)