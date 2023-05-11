package com.ca.channels.presentation

import kotlinx.coroutines.flow.StateFlow

interface ChannelsViewModel {
    val viewState: StateFlow<ChannelsViewState>
    suspend fun channels()
}