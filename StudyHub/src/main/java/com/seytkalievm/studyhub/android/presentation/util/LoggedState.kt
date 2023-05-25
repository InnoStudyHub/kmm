package com.seytkalievm.studyhub.android.presentation.util

sealed class LoggedState {

    object Loading: LoggedState()
    object LoggedIn: LoggedState()
    object NotLoggedIn: LoggedState()
}
