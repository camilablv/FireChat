package com.ca.chat.presentation

import com.ca.chat.domain.model.Message
import kotlinx.coroutines.flow.StateFlow

interface ChatViewModel {

    val messages: StateFlow<List<Message>>
}