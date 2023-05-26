package com.seytkalievm.studyhub.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val access: String,
    val refresh: String
)