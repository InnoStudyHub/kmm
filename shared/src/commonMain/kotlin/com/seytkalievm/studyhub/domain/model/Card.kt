package com.seytkalievm.studyhub.domain.model

class Card(
    val id: Int,
    val question: String,
    val questionImageUrl: String?,
    val answer: String?,
    val answerImageUrls: List<String>?
) {
    companion object {
        fun fromJson(json: Map<String, Any?>): Card {
            var answerImages: MutableList<String>? = null
            var questionImage: String? = null
            var answer: String? = null
            if (json["answer_images"] != null) {
                answerImages = mutableListOf()
                val answerImagesJson = json["answer_images"] as List<*>
                answerImagesJson.forEach { answerImages += it as String }
            }
            if (json["question_image"] != null) {
                questionImage = json["question_image"] as String
            }
            if (json["answer_text"] != null) {
                answer = json["answer_text"] as String
            }
            return Card(
                id = json["card_id"] as Int,
                question = json["question_text"] as String,
                questionImageUrl = questionImage,
                answer = answer,
                answerImageUrls = answerImages
            )
        }
    }
}