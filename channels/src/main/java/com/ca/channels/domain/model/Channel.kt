package com.ca.channels.domain.model

data class Channel(
    val avatarUrl: String,
    val nickname: String,
    val lastMessage: String,
    val lastMessageTimestamp: String,
    val unreadMessagesCount: Int
)