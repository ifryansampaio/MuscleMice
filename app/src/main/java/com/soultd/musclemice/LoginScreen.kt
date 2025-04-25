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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

    val gradientColors = listOf( //lista de cores pro gradient do fundo
        Color(0xFF0F0F23),
        Color(0xFF341A6E)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(gradientColors)) //aplicando gradient no fundo
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
            //Chama o campo de email com valor atual e atualiza quando digitar
            EmailTextField(email) {email = it}
            PasswordTextField(password) {password = it}
            LoginButton()


        }
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 35.dp, vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = "LOGIN",
            fontSize = 16.sp
        )
    }
}

@Composable
fun PasswordTextField(value: String, onValueChange: (String) -> Unit) {

    var isPasswordVisible by remember { mutableStateOf(false) } // Estado da visibilidade
    val visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        value = value, // valor atual do campo
        onValueChange = onValueChange, // função chamada quando o valor muda

        modifier = Modifier
            .fillMaxWidth() // ocupa a largura toda
            .height(66.dp) // altura do campo
            .padding(horizontal = 35.dp, vertical = 6.dp),

        shape = RoundedCornerShape(50), // cantos arredondados

        textStyle = TextStyle(
            fontSize = 20.sp, // tamanho da fonte
        ),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White, // borda ao focar
            unfocusedBorderColor = Color.White, // borda padrão
            textColor = Color.White, // cor do texto
            placeholderColor = Color.White, // cor do texto do placeholder

        ),

        placeholder = {

            Text(
                text = "Password",
                color = Color.White
            )
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock, // usa o ícone padrão de email
                contentDescription = null, // descrição para acessibilidade
                tint = Color.White, // cor branca pra combinar com o tema
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 10.dp, top = 2.dp)
            )
        },

        visualTransformation = visualTransformation,
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                val icon = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                Icon(imageVector = icon, contentDescription = null, tint = Color.White)
            }
        }

    )
}

@Composable
fun EmailTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value, // valor atual do campo
        onValueChange = onValueChange, // função chamada quando o valor muda

        modifier = Modifier
            .fillMaxWidth() // ocupa a largura toda
            .height(66.dp) // altura do campo
            .padding(horizontal = 35.dp, vertical = 6.dp),

        shape = RoundedCornerShape(50), // cantos arredondados

        textStyle = TextStyle(
            fontSize = 20.sp, // tamanho da fonte
        ),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White, // borda ao focar
            unfocusedBorderColor = Color.White, // borda padrão
            textColor = Color.White, // cor do texto
            placeholderColor = Color.White, // cor do texto do placeholder

        ),

        placeholder = {

            Text(
                text = "Email",
                color = Color.White
            )
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email, // usa o ícone padrão de email
                contentDescription = null, // descrição para acessibilidade
                tint = Color.White, // cor branca pra combinar com o tema

                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 10.dp, top = 2.dp)
            )
        }
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
