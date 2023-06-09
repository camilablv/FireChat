package com.ca.chat

import android.app.Application
import com.ca.auth.di.authModule
import com.ca.channels.di.channelsModule
import com.ca.chat.di.appModule
import com.ca.chat.di.chatModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FireChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FireChatApplication)
            modules(
                appModule,
                channelsModule,
                authModule,
                chatModule
            )
        }
    }
}