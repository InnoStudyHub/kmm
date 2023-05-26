package com.seytkalievm.studyhub.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Folder(
    @SerialName("folder_id")
    val id: Int,
    @SerialName("folder_name")
    val name: String
)
