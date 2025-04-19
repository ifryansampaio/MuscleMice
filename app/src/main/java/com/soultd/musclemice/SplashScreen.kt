package com.soultd.musclemice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable

fun SplashScreen(){
    Box(modifier = Modifier.fillMaxSize()) { //Preenche toda a tela
        Image(
            painter = painterResource(id = R.drawable.mice_icon_purple),
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .align(Alignment.Center)
        )
    }


}
