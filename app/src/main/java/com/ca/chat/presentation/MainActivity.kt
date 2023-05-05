package com.ca.chat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ca.auth.presentation.signin.SignInScreen
import com.ca.chat.presentation.navigation.Routes
import com.ca.channels.presentation.ChannelsScreen
import com.ca.core.presentation.theme.ChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatTheme {
                NavigationHost(navController = rememberNavController())
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.CHANNELS.route) {
        composable(Routes.LOGIN.route) {
            SignInScreen()
        }
        composable(Routes.CHANNELS.route) {
            ChannelsScreen {

            }
        }
    }
}