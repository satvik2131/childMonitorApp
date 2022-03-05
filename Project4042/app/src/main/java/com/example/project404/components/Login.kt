package com.example.project404

import android.view.Surface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginWithGoogle(navController: NavController){
        Column(
            modifier = Modifier
                .fillMaxSize()

            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Login As")
            TextButton(onClick = { navController.navigate("childInfo")}) {
                Text("Parent")
            }
        }
}

@Composable
@Preview
fun LoginWithGooglePreview(){
    LoginWithGoogle(navController = rememberNavController())
}

