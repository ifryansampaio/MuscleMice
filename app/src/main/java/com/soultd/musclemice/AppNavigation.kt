package com.soultd.musclemice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        //composable("home") { HomeScreen(navController) }
        //composable("start_workout") { StartWorkoutScreen(navController) }
        //composable("series_timer") { SeriesTimerScreen(navController) }

        //composable("settings") { SettingsScreen(navController) }
    }
}
