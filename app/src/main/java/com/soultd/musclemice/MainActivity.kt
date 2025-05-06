package com.soultd.musclemice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.soultd.musclemice.ui.theme.MuscleMiceTheme
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // Deixa o app em tela cheia (oculta barra de navegação e status bar)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.navigationBars()) // oculta a nav bar
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        enableEdgeToEdge()
        setContent {
            MuscleMiceTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigation()
                }
            }
        }
    }
}
