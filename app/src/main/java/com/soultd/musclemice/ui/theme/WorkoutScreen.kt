package com.soultd.musclemice

import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WorkoutScreen(navController: NavController) {
    var selectedRestTime by remember { mutableStateOf("60") } // valor em segundos como string para input
    var restTime by remember { mutableStateOf(60) } // valor real em segundos
    var timeLeft by remember { mutableStateOf(restTime) }
    var timerRunning by remember { mutableStateOf(false) }
    var currentSet by remember { mutableStateOf(1) }
    val totalSets = 4

    var timer: CountDownTimer? by remember { mutableStateOf(null) }

    LaunchedEffect(timerRunning) {
        if (timerRunning) {
            timer = object : CountDownTimer(timeLeft * 1000L, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timeLeft = (millisUntilFinished / 1000).toInt()
                }

                override fun onFinish() {
                    timeLeft = 0
                    timerRunning = false
                }
            }.start()
        } else {
            timer?.cancel()
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Treino Atual", style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Série $currentSet de $totalSets", style = MaterialTheme.typography.subtitle1)

                Spacer(modifier = Modifier.height(24.dp))

                // Escolher tempo de descanso
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Tempo de descanso: ")
                    TextField(
                        value = selectedRestTime,
                        onValueChange = { newValue ->
                            if (newValue.all { it.isDigit() }) {
                                selectedRestTime = newValue
                            }
                        },
                        modifier = Modifier.width(80.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Text("segundos")
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        restTime = selectedRestTime.toIntOrNull() ?: 60
                        timeLeft = restTime
                        timerRunning = false
                    }) {
                        Text("Aplicar")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text("Tempo restante: ${timeLeft}s", style = MaterialTheme.typography.h4)

                Spacer(modifier = Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(onClick = { timerRunning = true }) {
                        Text("Iniciar")
                    }
                    Button(onClick = { timerRunning = false }) {
                        Text("Pausar")
                    }
                    Button(onClick = {
                        timerRunning = false
                        timeLeft = restTime
                    }) {
                        Text("Resetar")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        if (currentSet < totalSets) {
                            currentSet++
                            timeLeft = restTime
                            timerRunning = false
                        } else {
                            timerRunning = false
                            currentSet = 1
                            timeLeft = restTime
                            // Em breve: registrar treino
                        }
                    }
                ) {
                    Text(if (currentSet < totalSets) "Próxima Série" else "Finalizar Treino")
                }
            }
    }
}
