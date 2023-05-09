package com.ca.channels.presentation

import androidx.lifecycle.ViewModel
import com.ca.channels.domain.usecase.GetChannelsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChannelsViewModelImpl(
    val getChatListUseCase: GetChannelsUseCase
) : ViewModel(), ChannelsViewModel {

    private var _viewState = MutableStateFlow(ChannelsViewState())
    override val viewState: StateFlow<ChannelsViewState>
        get() = _viewState

    override fun channels() {
        val channels = getChatListUseCase.channels()
        _viewState.value = _viewState.value.copy(channels = channels)
    }
}