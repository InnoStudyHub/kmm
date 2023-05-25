package com.seytkalievm.studyhub.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Card(
    @SerialName("card_id")
    val id: Int,
    @SerialName("question_text")
    val question: String,
    @SerialName("question_image")
    val questionImageUrl: String?,
    @SerialName("answer_text")
    val answer: String?,
    @SerialName("answer_images")
    val answerImageUrls: List<String>?
)
