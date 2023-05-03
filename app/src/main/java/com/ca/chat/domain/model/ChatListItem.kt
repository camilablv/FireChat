package com.ca.chat.domain.model

data class ChatListItem(
    val avatarUrl: String,
    val nickname: String,
    val lastMessage: String,
    val lastMessageTimestamp: String
)