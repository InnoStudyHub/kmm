package com.seytkalievm.studyhub.android.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.api.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val authApi: AuthApi
): ViewModel() {
    private val isLoggedIn: Flow<Boolean> = flow { emit(authApi.isLoggedIn()) }

    val loggedState = isLoggedIn.map {isLoggedIn ->
        if(isLoggedIn) LoggedState.LoggedIn else LoggedState.NotLoggedIn
    }.stateIn(
        initialValue = LoggedState.Loading,
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L)
    )

}