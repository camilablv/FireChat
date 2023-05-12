package com.ca.chat.domain.usecase

import com.ca.chat.domain.model.Message
import com.ca.chat.domain.repository.ChatRepository

class GetMessagesUseCase(val repository: ChatRepository) {

    fun messages(chatId: String): List<Message> {
        return listOf(
            Message("", "In our previous article about Jetpack Compose, we shared our initial impressions and recommended some learning resources.", "", "15:45", emptyList()),
            Message("", "This time, we'll take Compose out for a spin by building a basic chat UI implementation with it.", "", "15:45", emptyList()),
            Message("", "Of course, you might be wondering why we're building a Compose Chat app when there's an official Google sample, Jetchat, which is also a chat app using Compose", "", "15:45", emptyList()),
            Message("", "That sample is a basic UI demo with a small bit of hardcoded data", "", "15:45", emptyList())
        )
    }
}