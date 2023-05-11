package com.ca.channels.presentation

import com.ca.channels.domain.model.Channel

data class ChannelsViewState(
    val loading: Boolean = false,
    val channels: List<Channel> = emptyList()
)