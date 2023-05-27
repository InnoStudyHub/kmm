package com.seytkalievm.studyhub.android.presentation.session.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.api.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfilePageViewModel @Inject constructor(
    //private val savedStateHandle: SavedStateHandle,
    private val authApi: AuthApi
) : ViewModel() {

    //private val isLoggedIn: Flow<Boolean> = savedStateHandle.getStateFlow("log_out", true)

    private val isLoggedIn: Flow<Boolean> = flow { emit(authApi.isLoggedIn()) }

    /*val loggedState = isLoggedIn.map {isLoggedIn ->
        if(isLoggedIn) LoggedState.LoggedIn else LoggedState.NotLoggedIn
    }.stateIn(
        initialValue = LoggedState.Loading,
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L)
    )*/

    val state = isLoggedIn.map { isLoggedIn ->
        ProfilePageState(isLoggedInState = isLoggedIn)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ProfilePageState())

    /*fun cheksIsLoggedIn() {
        viewModelScope.launch {
            savedStateHandle["log_out"] = authApi.isLoggedIn()
        }
    }*/


    fun logout() {
        viewModelScope.launch {
            authApi.logout()
        }
    }
}