package com.seytkalievm.studyhub.android.presentation.session.search

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.api.StudyHubApi
import com.seytkalievm.studyhub.domain.model.Deck
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchPageViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val studyHubApi: StudyHubApi,
) : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _resultDecks = MutableStateFlow(listOf<Deck>())
    val resultDecks = searchText
        .debounce(500L)
        .onEach { _isSearching.update { true } }
        .combine(_resultDecks) { text, result ->
            if(text.isBlank()) {
                Log.d("LOG_SEARCH", "Text is blank")
                studyHubApi.searchDecks("")
            } else {
                Log.d("LOG_SEARCH", "Text is not blank")
                //TODO(присвоить значение поиска)
                studyHubApi.searchDecks(text)
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _resultDecks.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    /*private val result = savedStateHandle.getStateFlow("searchResult", listOf<Deck>())

    val state = combine(result) { decks ->
        SearchPageState(searchedDecks = decks[0])
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SearchPageState())

    fun search(query: String) {
        viewModelScope.launch {
            savedStateHandle["searchResult"] = studyHubApi.searchDecks(query)
        }
    }*/
}