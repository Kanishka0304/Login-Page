package com.example.sign_up

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sign_up.com.example.sign_up.ui.theme.registerScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable(route="splash"){
            SplashScreen(navController)
        }
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "register") {
            registerScreen(navController)
        }
        composable(route="login"){
            LoginScreen(navController)
        }
    }
}
