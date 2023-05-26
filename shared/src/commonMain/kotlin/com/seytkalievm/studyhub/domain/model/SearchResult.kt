package com.seytkalievm.studyhub.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val decks: List<Deck>,
    val folders: List<Folder>
)