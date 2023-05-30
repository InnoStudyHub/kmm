package com.seytkalievm.studyhub.android.presentation.session.search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seytkalievm.studyhub.android.presentation.session.common_widgets.DeckItem
import com.seytkalievm.studyhub.android.presentation.util.Screen
import com.seytkalievm.studyhub.android.presentation.util.toJson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun SearchPage(
    navController: NavController,
    viewModel: SearchPageViewModel = hiltViewModel(),
) {
    //val state by viewModel.state.collectAsState()
    val searchText by viewModel.searchText.collectAsState()
    val resultDecks by viewModel.resultDecks.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Search for decks") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (isSearching) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                if (resultDecks.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "No results",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.Black
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Log.d("LOG_SEARCH", resultDecks.size.toString())
                        items(resultDecks) { deck ->
                            DeckItem(
                                deck = deck,
                                onDeckClick = {
                                    val deckString = deck.toJson()
                                    val encode =
                                        URLEncoder.encode(
                                            deckString,
                                            StandardCharsets.UTF_8.toString()
                                        )
                                    navController.navigate(
                                        Screen.DeckViewScreen.withArgs(encode)
                                    )
                                },
                            )
                        }
                    }
                }
            }
        }
    }
}