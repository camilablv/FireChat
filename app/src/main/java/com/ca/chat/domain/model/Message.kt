package com.ca.chat.domain.model

data class Message(
    val id: String,
    val nickname: String,
    val text: String,
    val timestamp: String
)
