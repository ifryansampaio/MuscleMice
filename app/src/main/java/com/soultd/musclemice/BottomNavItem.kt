package com.soultd.musclemice

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Início")
    object Workout : BottomNavItem("start_workout", Icons.Default.FitnessCenter, "Treino")
    object Timer : BottomNavItem("series_timer", Icons.Default.Timer, "Séries")
}
