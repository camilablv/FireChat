package com.ca.channels.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ca.channels.domain.model.Channel
import com.ca.channels.domain.usecase.GetChannelsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChannelsViewModelImpl(
    private val getChatListUseCase: GetChannelsUseCase
) : ViewModel(), ChannelsViewModel {

    private var _viewState = MutableStateFlow(ChannelsViewState())
    override val viewState: StateFlow<ChannelsViewState>
        get() = _viewState

    override suspend fun channels() {
        simulateLoadingAndDelay() //todo remove it later
        val channels = getChatListUseCase.channels()
        _viewState.value = _viewState.value.copy(loading = false, channels = channels)
    }

    //todo remove it later
    suspend fun simulateLoadingAndDelay() {
        _viewState.value = _viewState.value.copy(loading = true)
        delay(3000L)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ChannelsViewModelImpl", "CLEARED")
    }
}