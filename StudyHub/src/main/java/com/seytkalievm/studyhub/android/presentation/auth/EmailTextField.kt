package com.seytkalievm.studyhub.android.presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    value: MutableState<String>
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        singleLine = true,
        value = value.value,
        label = { Text("Email") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email")
        },
        onValueChange = { login -> value.value = login },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}