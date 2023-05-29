package com.seytkalievm.studyhub.android.presentation.util

import com.google.gson.Gson

fun <T> String.fromJson(type: Class<T>): T {
    return Gson().fromJson(this.trim(), type)
}

fun <T> T.toJson(): String? {
    return Gson().toJson(this)
}