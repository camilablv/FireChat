package com.ca.channels.presentation

import androidx.lifecycle.ViewModel
import com.ca.channels.domain.usecase.GetChannelsUseCase

class ChannelsViewModelImpl(
    getChatListUseCase: GetChannelsUseCase
) : ViewModel(), ChannelsViewModel {

    override fun channels() {

    }
}