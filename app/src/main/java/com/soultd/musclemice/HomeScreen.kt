package com.soultd.musclemice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.soultd.musclemice.ui.theme.infomaFontFamily

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF1C1B3A),
                elevation = 4.dp,
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.FitnessCenter,
                            contentDescription = "App Icon",
                            tint = Color(0xFF8148E3),
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = "MuscleMice",
                            fontFamily = infomaFontFamily,
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        },
        backgroundColor = Color(0xFF0F0F23)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Botão: Start Workout
            HomeOptionCard(
                icon = Icons.Default.FitnessCenter,
                text = "Start Workout",
                onClick = { navController.navigate("start_workout") },
                color = Color(0xFF6A1B9A)
            )

            // Botão: Series Timer
            HomeOptionCard(
                icon = Icons.Default.Timer,
                text = "Series Timer",
                onClick = { navController.navigate("series_timer") },
                color = Color(0xFF283593)
            )

            // Botão: Workout History
            HomeOptionCard(
                icon = Icons.Default.History,
                text = "Workout History",
                onClick = { navController.navigate("history") },
                color = Color(0xFF00695C)
            )

            // Botão: Settings
            HomeOptionCard(
                icon = Icons.Default.Settings,
                text = "Settings",
                onClick = { navController.navigate("settings") },
                color = Color(0xFF37474F)
            )
        }
    }
}

// Card estilizado para cada opção
@Composable
fun HomeOptionCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    onClick: () -> Unit,
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = color,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = infomaFontFamily
            )
        }
    }
}

// Preview da tela Home
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
