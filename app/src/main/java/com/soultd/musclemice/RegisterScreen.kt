package com.soultd.musclemice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen(
    onSignUpClick: (String, String, String) -> Unit,
    onNavigateToLogin: () -> Unit
) {
    SignUpApp(onSignUpClick = onSignUpClick, onNavigateToLogin = onNavigateToLogin)
}

@Composable
fun SignUpApp(
    onSignUpClick: (String, String, String) -> Unit = { _, _, _ -> },
    onNavigateToLogin: () -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
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
            Spacer(modifier = Modifier.height(50.dp))

            NameTextField(name) { name = it }
            EmailTextField(email) { email = it }
            PasswordTextField(password) { password = it }

            SignUpConfirmButton(name, email, password) { name, email, pass ->
                onSignUpClick(name, email, pass)
            }

            LoginRedirectText { onNavigateToLogin() }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpApp()
}

@Composable
fun NameTextField(value: String, onValueChange: (String) -> Unit) {
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
        placeholder = { Text("Name", color = Color.White) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 10.dp, top = 2.dp)
            )
        }
    )
}

@Composable
fun SignUpConfirmButton(
    name: String,
    email: String,
    password: String,
    onClick: (String, String, String) -> Unit
) {
    Button(
        onClick = { onClick(name, email, password) },
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 35.dp, vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(50)
    ) {
        Text(text = "SIGN UP", fontSize = 16.sp)
    }
}

@Composable
fun LoginRedirectText(onClick: () -> Unit) {
    Text(
        text = "Already have an account? Login",
        color = Color.White,
        fontSize = 14.sp,
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable { onClick() },
        textAlign = TextAlign.Center
    )
}
