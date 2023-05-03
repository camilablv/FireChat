package com.ca.chat.presentation

import androidx.lifecycle.ViewModel
import com.ca.chat.domain.usecase.GetChatListUseCase

class ChatViewModelImpl(
    getChatListUseCase: GetChatListUseCase
) : ViewModel(), ChatViewModel {

    override fun chatList() {

    }
}