package com.ca.chat.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatViewModelImpl : ViewModel(), ChatViewModel {

    val typedMessage = mutableStateOf("")

}