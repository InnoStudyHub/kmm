package com.seytkalievm.studyhub.android.presentation.session.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seytkalievm.studyhub.android.presentation.session.common_widgets.DeckItem
import com.seytkalievm.studyhub.android.presentation.util.Screen
import com.seytkalievm.studyhub.android.presentation.util.toJson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomePage(
    navController: NavController,
    viewModel: HomePageViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.loadDecks()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.decks.size) { i ->
                DeckItem(
                    deck = state.decks[i],
                    onDeckClick = {
                        val deckString = state.decks[i].toJson()
                        val encode =
                            URLEncoder.encode(deckString, StandardCharsets.UTF_8.toString())
                        navController.navigate(
                            Screen.DeckViewScreen.withArgs(encode)
                        )
                    },
                )
            }
        }
    }
}