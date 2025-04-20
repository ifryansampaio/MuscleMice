package com.soultd.musclemice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable

fun SplashScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) { //Preenche toda a tela
        BackgroundSplash()
        LaunchedEffect(Unit) {
            delay(2500)
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable

fun BackgroundSplash() {
    Box(modifier = Modifier.fillMaxSize()) { //Preenche toda a tela
        Image(
            painter = painterResource(id = R.drawable.mice_icon_purple),
            contentDescription = null,
            modifier = Modifier
                .width(220.dp)
                .align(Alignment.Center)
        )
    }
}
