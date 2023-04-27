package com.ca.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ca.auth.presentation.login.LoginScreen
import com.ca.auth.presentation.navigation.Routes
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
    NavHost(navController = navController, startDestination = Routes.LOGIN.route) {
        composable(Routes.LOGIN.route) {
            LoginScreen()
        }
    }
}