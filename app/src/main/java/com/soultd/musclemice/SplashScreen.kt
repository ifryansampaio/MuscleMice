package com.soultd.musclemice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box() {
        BackgroundSplash() // Chamada da função de splash

        LaunchedEffect(Unit) {  // Dispara um efeito quando a tela entra em composição
            delay(2500)
            navController.navigate("login") { // navega para a tela de login
                popUpTo("splash") { inclusive = true } // remove a Splash da pilha de navegação
            }
        }
    }
}

@Preview(showBackground = true) // permite visualizar no Android Studio Preview
@Composable
fun BackgroundSplash() { // Função responsável por desenhar o conteúdo visual da splash
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F23))
    ) { // Container ocupando a tela toda e com fundo azul
        Image(
            painter = painterResource(id = R.drawable.mice_icon_purple), // carrega a imagem da logo
            contentDescription = null, // sem descrição de acessibilidade
            modifier = Modifier
                .width(220.dp) // define largura fixa da imagem
                .align(Alignment.Center) // centraliza no meio da tela
        )
    }
}

