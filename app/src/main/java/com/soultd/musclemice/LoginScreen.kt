package com.soultd.musclemice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soultd.musclemice.ui.theme.infomaFontFamily


@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit, //e-mail e senha pra logar
    onNavigateToRegister: () -> Unit //navegar para a tela de cadastro
) {
    LoginApp()
}

@Preview(showBackground = true)
@Composable

fun LoginApp () {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F23))
    ) { //cria um container na tela inteira, com fundo azul
        Column ( //Os itens ficaram um abaixo do outro na tela
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally, //Alinhamento no centro horizontalmente
            verticalArrangement = Arrangement.Center //Arranjamento no centro verticalmente
        ) {
            ImageLogo(R.drawable.mice_icon_purple)
            TextLogo()
            EmailTextField(email) {email = it}

        }
    }
}

@Composable
fun EmailTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 64.dp, vertical = 8.dp),
        shape = RoundedCornerShape(50),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
        ),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
        ),
        placeholder = {Text(text = "Email", textAlign = TextAlign.Left, color = Color.White)}
    )
}


@Composable
fun TextLogo() {
    Text(
        text = "MuscleMice",
        fontSize = 30.sp,
        fontFamily = infomaFontFamily,
        color = Color(0xFF8148E3)
    )
}

@Composable
fun ImageLogo(resId: Int) {
    Image(painter = painterResource(id = resId),
        contentDescription = null,
        modifier = Modifier
            .height(120.dp)
    )
    }
