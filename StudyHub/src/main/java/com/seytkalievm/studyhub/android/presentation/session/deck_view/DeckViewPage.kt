package com.seytkalievm.studyhub.android.presentation.session.deck_view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seytkalievm.studyhub.domain.model.Deck

@Composable
fun DeckViewPage(
    deck: Deck,
    viewModel: DeckViewPageViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    Log.d("LOG_DECK", deck.toString())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DeckInfo(
            title = deck.deckName,
            author = deck.authorId.toString(),
            year = deck.semester,
            number = deck.cards.size
        )
        LazyRow {
            items(deck.cards.size) { index ->
                DeckCard(question = deck.cards[index].question)
            }
        }
        //ScrollableCards()
        Buttons()
    }
}

@Composable
private fun DeckInfo(title: String, author: String, year: String, number: Int, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth(),
    ) {
        InfoField(text = title, imageVector = Icons.Default.Folder)
        InfoField(text = author, imageVector = Icons.Default.PersonOutline)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoField(text = year, imageVector = Icons.Default.CalendarMonth)
            NumberOfCards(cards = number)
        }
    }
}

@Composable
private fun InfoField(
    text: String,
    imageVector: ImageVector
) {
    Row {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .height(28.dp)
                .width(28.dp)
                .padding(end = 10.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight(300)
        )
    }
}

@Composable
private fun NumberOfCards(cards: Int, modifier: Modifier = Modifier) {
    Box(
        modifier
            .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$cards cards",
            color = Color.DarkGray,
            fontSize = 12.sp,
            fontWeight = FontWeight(600)
        )
    }
}

@Composable
private fun ScrollableCards() {
    LazyRow {
        items(8) {
            DeckCard(question = "Should change this text")
        }
    }
}

@Composable
private fun DeckCard(question: String) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(300.dp)
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp),
        backgroundColor = Color.LightGray,
        contentColor = Color.Black,
        elevation = 8.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = question,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun Buttons(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier
                .width(320.dp)
                .height(44.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
        ) {
            Text(text = "Start")
        }
        Spacer(modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier
                .width(320.dp)
                .height(44.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
        ) {
            Text(text = "Overview")
        }
    }
}