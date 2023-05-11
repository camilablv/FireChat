package com.ca.channels.domain.usecase

import com.ca.channels.domain.model.Channel
import com.ca.channels.domain.repository.ChannelsRepository

class GetChannelsUseCase(val repository: ChannelsRepository) {

    fun channels(): List<Channel> {
        return List(20) {
            Channel("", "Dima", "Last message...", "12:08", 3)
        }
    }
}