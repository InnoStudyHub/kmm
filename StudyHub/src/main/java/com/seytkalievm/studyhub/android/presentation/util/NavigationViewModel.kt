package com.seytkalievm.studyhub.android.presentation.util

import androidx.lifecycle.ViewModel
import com.seytkalievm.studyhub.domain.api.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val authApi: AuthApi
): ViewModel() {


    private val _loggedState = authApi.isLoggedIn.map { isLoggedIn ->
        if (isLoggedIn) LoggedState.LoggedIn else LoggedState.NotLoggedIn
    }

    val loggedState get() = _loggedState
}