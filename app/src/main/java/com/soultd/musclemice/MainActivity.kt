package com.soultd.musclemice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.soultd.musclemice.ui.theme.MuscleMiceTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MuscleMiceTheme {  //Aplica o tema a UI

                val navController = rememberNavController() //Cria e lembra um NavControl

                NavHost(navController = navController, startDestination = "splash") {
                    composable(route = "splash") {
                        SplashScreen(navController = navController)
                    }

                    composable(route = "login"){
                        //LoginScreen()
                    }
                }
            }
        }
    }
}