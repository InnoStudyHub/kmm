package com.seytkalievm.studyhub

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform