package com.seytkalievm.studyhub.android.presentation.session.common_widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seytkalievm.studyhub.domain.model.Deck

@Composable
fun DeckItem(
    deck: Deck,
    onDeckClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .clickable { onDeckClick() }
            .background(Color.LightGray)
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top=10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DeckTitle(title = deck.deckName)
            NumberOfCards(cards = deck.cards.size)
        }

        CourseName(name = deck.deckName)
        Divider(
            thickness = 1.dp,
            color = Color.Black
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Semester(semester = deck.semester)
            Box(modifier = Modifier.fillMaxSize())
            Icon(
                imageVector = Icons.Default.BookmarkBorder,
                contentDescription = null,
                modifier = Modifier
                    .height(18.dp)
                    .width(15.dp)
            )
        }
    }
}

@Composable
private fun DeckTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        color = Color.DarkGray,
        fontSize = 16.sp,
        fontWeight = FontWeight(600),
        modifier = modifier
    )
}

@Composable
private fun NumberOfCards(cards: Int, modifier: Modifier = Modifier) {
    Box(
        modifier
            .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)
            .width(18.dp)
            .height(22.dp)
            .clip(RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = cards.toString(),
            color = Color.DarkGray,
            fontSize = 12.sp,
            fontWeight = FontWeight(600)
        )
    }
}

@Composable
private fun CourseName(name: String, modifier: Modifier = Modifier) {
    Box(modifier.padding(top = 8.dp, bottom = 8.dp)) {
        Text(
            text = name,
            color = Color.DarkGray,
            fontSize = 14.sp,
            fontWeight = FontWeight(400)
        )
    }
}

@Composable
private fun Semester(semester: String, modifier: Modifier = Modifier) {
    Box (modifier = modifier.padding(top=7.dp)){
        Text(
            text = semester,
            color = Color.DarkGray,
            fontSize = 14.sp,
            fontWeight = FontWeight(400)
        )
    }
}