package com.seytkalievm.studyhub.android.presentation.session.search

import com.seytkalievm.studyhub.domain.model.Deck

data class SearchPageState (
    var searchedDecks: List<Deck> = emptyList()
)