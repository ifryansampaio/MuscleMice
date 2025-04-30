package com.soultd.musclemice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
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
    onLoginClick: (String, String) -> Unit,
    onNavigateToRegister: () -> Unit
) {
    LoginApp(onLoginClick = onLoginClick, onNavigateToRegister = onNavigateToRegister)
}

// Tela principal de login
@Composable
fun LoginApp(
    onLoginClick: (String, String) -> Unit = { _, _ -> }, // função padrão pro preview
    onNavigateToRegister: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val gradientColors = listOf(
        Color(0xFF0F0F23),
        Color(0xFF341A6E)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(gradientColors))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageLogo(R.drawable.mice_icon_purple)
            TextLogo()
            Spacer(modifier = Modifier.height(50.dp)) //afastar a logo do resto
            EmailTextField(email) { email = it }
            PasswordTextField(password) { password = it }
            LoginButton(email, password) { email, pass ->
                onLoginClick(email, pass) // só navega, sem autenticar
            }
            SignUpButton {
                onNavigateToRegister()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginAppPreview() {
    LoginApp()
}

// Logo do app
@Composable
fun ImageLogo(resId: Int) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = Modifier.height(120.dp)
    )
}

// Texto "MuscleMice" com fonte personalizada
@Composable
fun TextLogo() {
    Text(
        text = "MuscleMice",
        fontSize = 30.sp,
        fontFamily = infomaFontFamily,
        color = Color(0xFF8148E3)
    )
}

// Campo de email
@Composable
fun EmailTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 35.dp, vertical = 6.dp),
        shape = RoundedCornerShape(50),
        textStyle = TextStyle(fontSize = 20.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            textColor = Color.White,
            placeholderColor = Color.White
        ),
        placeholder = { Text("Email", color = Color.White) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(30.dp).padding(start = 10.dp, top = 2.dp)
            )
        }
    )
}

// Campo de senha com botão de mostrar/ocultar
@Composable
fun PasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 35.dp, vertical = 6.dp),
        shape = RoundedCornerShape(50),
        textStyle = TextStyle(fontSize = 20.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            textColor = Color.White,
            placeholderColor = Color.White
        ),
        placeholder = { Text("Password", color = Color.White) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(30.dp).padding(start = 10.dp, top = 2.dp)
            )
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    )
}

// Botão que chama apenas a função de navegação
@Composable
fun LoginButton(
    email: String,
    password: String,
    onLoginClick: (String, String) -> Unit
) {
    Button(
        onClick = {
            onLoginClick(email, password) // navega pra próxima tela
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 35.dp, vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(50)
    ) {
        Text(text = "LOGIN", fontSize = 16.sp)
    }
}

@Composable
fun SignUpButton(onClick: () -> Unit) {
    Text(
        text = "Don't have an account? Sing Up",
        color = Color.White,
        fontSize = 14.sp,
        modifier = Modifier
            .padding(top =12.dp)
            .clickable{ onClick() },
        textAlign = TextAlign.Center
    )
}