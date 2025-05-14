package com.soultd.musclemice

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val username = "Marombeiro" // Mock
    val level = "Frango"
    val progress = 0.6f // 60%
    val dicas = listOf(
        "Sem dor, sem ganho!",
        "Hoje é dia de peito!",
        "Só vai!",
        "Bora bater meta!",
        "Treino dado é treino pago!"
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Bem-vindo de volta, $username!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Nível: $level",
                fontSize = 18.sp,
                color = Color.Gray
            )

            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Pronto para o treino de hoje?", color = Color.White)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        navController.navigate("workout") // Corrigido para a navegação correta
                    }) {
                        Text("Iniciar Treino")
                    }
                }
            }

            Text("Frases motivacionais", fontWeight = FontWeight.SemiBold)
            LazyRow {
                items(dicas) { dica ->
                    Card(
                        backgroundColor = Color.LightGray,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .width(220.dp)
                    ) {
                        Box(modifier = Modifier.padding(12.dp)) {
                            Text(dica)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            LinearProgressIndicator(progress = progress)
            Text("Você completou ${(progress * 100).toInt()}% do plano de treino da semana")

            Button(
                onClick = { /* navegar para estatísticas depois */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Ver estatísticas")
            }
        }
    }
}