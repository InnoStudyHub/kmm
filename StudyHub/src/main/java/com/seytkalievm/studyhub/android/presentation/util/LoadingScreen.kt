package com.seytkalievm.studyhub.android.presentation.util

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(){
    Scaffold {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {}
    }
}