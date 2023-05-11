package com.ca.chat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.ca.auth.presentation.signin.SignInScreen
import com.ca.channels.presentation.ChannelsScreen
import com.ca.chat.presentation.navigation.Routes
import com.ca.core.presentation.theme.ChatTheme
import com.google.accompanist.navigation.animation.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatTheme {
                NavigationHost(navController = rememberAnimatedNavController())
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationHost(navController: NavHostController) {
    AnimatedNavHost(navController = navController, startDestination = Routes.CHANNELS.route) {
        composable(
            route = Routes.LOGIN.route,
            enterTransition = null,
            exitTransition = null
        ) {
            SignInScreen {
                navController.navigate(Routes.CHANNELS.route) {
                    popUpTo(Routes.LOGIN.route) { inclusive = true }
                }
            }
        }
        composable(
            route = Routes.CHANNELS.route,
            enterTransition = null,
            exitTransition = null
        ) {
            ChannelsScreen {
                navController.navigate(Routes.CHAT.route)
            }
        }
        composable(
            route = Routes.CHAT.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right) }
        ) {
            ChatScreen(
                onAvatarClick = {},
                onNavigationIconClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}