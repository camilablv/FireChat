package com.ca.chat.domain.model

data class Message(
    val id: String,
    val body: String,
    val userId: String,
    val createdAt: String,
    val viewedBy: List<String>
)
