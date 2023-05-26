package com.seytkalievm.studyhub.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Deck(
    @SerialName("deck_id")
    val id: Int,
    @SerialName("folder_id")
    val folderId: Int,
    @SerialName("author_id")
    val authorId: Int,
    @SerialName("deck_name")
    val deckName: String,
    @SerialName("semester")
    val semester: String,
    val cards: List<Card>,
    @SerialName("is_favourite")
    val isFavourite: Boolean,
)
