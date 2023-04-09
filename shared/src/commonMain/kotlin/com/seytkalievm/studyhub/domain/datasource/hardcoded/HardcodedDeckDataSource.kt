package com.seytkalievm.studyhub.domain.datasource.hardcoded

import com.seytkalievm.studyhub.domain.datasource.DeckDataSource
import com.seytkalievm.studyhub.domain.model.Card
import com.seytkalievm.studyhub.domain.model.Deck
import kotlin.random.Random

class HardcodedDeckDataSource : DeckDataSource {

    override suspend fun getPopularDecks(): List<Deck> = buildList {
        val range = 1..Random.nextInt(5, 15)
        range.map { i ->
            add(
                Deck(
                    id = i,
                    folderId = i,
                    authorId = i,
                    deckName = "Deck $i",
                    semester = "F21",
                    cards = getCards(i),
                    isFavourite = false
                )
            )
        }
    }

    private fun getCards(deck: Int): List<Card> = buildList {
        val range = 1..Random.nextInt(5, 15)
        range.map { i ->
            add(
                Card(
                    id = i,
                    question = "Question $deck.$i",
                    questionImageUrl = null,
                    answer = "Answer $deck.$i",
                    answerImageUrls = null
                )
            )
        }
    }
}