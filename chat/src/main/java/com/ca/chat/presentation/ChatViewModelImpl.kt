package com.ca.chat.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ca.chat.domain.model.Message
import com.ca.chat.domain.usecase.GetMessagesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChatViewModelImpl(private val useCase: GetMessagesUseCase) : ViewModel(), ChatViewModel {

    val typedMessage = mutableStateOf("")

    private val _messages = MutableStateFlow(emptyList<Message>())
    override val messages: StateFlow<List<Message>>
        get() = _messages

    fun loadMessages(chatId: String) {
        _messages.value = useCase.messages(chatId)
    }

    fun sendMessage(
        message: String
    ) {
        val newMessage = Message("", message, "","", emptyList())
        _messages.value = _messages.value.plus(newMessage)
    }

    fun clearTextView() {
        typedMessage.value = ""
    }
}