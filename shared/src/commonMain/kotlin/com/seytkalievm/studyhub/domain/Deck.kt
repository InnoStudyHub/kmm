package com.seytkalievm.studyhub.domain

class Deck(
    val id: Int,
    val folderId: Int,
    val authorId: Int,
    val deckName: String,
    val semester: String,
    val cards: List<Card>,
    val isFavourite: Boolean
) {
    var folderName = ""

    companion object {
        fun fromJson(jsonMap: Map<String, Any?>): Deck {
            val cardsJson = jsonMap["cards"] as List<Map<String, Any?>>
            val cards = mutableListOf<Card>()
            for (cardJson in cardsJson) {
                cards.add(Card.fromJson(cardJson))
            }

            return Deck(
                id = jsonMap["deck_id"] as Int,
                folderId = jsonMap["folder_id"] as Int,
                authorId = jsonMap["author_id"] as Int,
                deckName = jsonMap["deck_name"] as String,
                semester = jsonMap["semester"] as String,
                isFavourite = jsonMap["is_favourite"] as Boolean,
                cards = cards
            )
        }
    }

    override fun toString(): String {
        return "Deck($id $folderId $authorId $deckName $semester)"
    }

    override fun hashCode(): Int {
        return id * folderId * authorId * deckName.hashCode() * semester.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Deck) {
            return id == other.id && folderId == other.folderId && authorId == other.authorId
        }

        return false
    }
}