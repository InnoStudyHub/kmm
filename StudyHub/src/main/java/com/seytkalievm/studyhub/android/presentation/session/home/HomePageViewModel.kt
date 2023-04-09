package com.seytkalievm.studyhub.android.presentation.session.home

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.datasource.DeckDataSource
import com.seytkalievm.studyhub.domain.model.Deck
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val dataSource: DeckDataSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val decks = savedStateHandle.getStateFlow("decks", listOf<Deck>())

    val state = combine(decks) { decks ->
        Log.i("HomePageViewModel", ": $decks")
        HomePageState(decks = decks[0])
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomePageState())

    fun loadDecks(){
        viewModelScope.launch {
            savedStateHandle["decks"] = dataSource.getPopularDecks()
        }
    }
}