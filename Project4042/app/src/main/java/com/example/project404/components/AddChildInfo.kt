package com.example.project404

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddChildInfo(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Text(text = "aajao")
        }
    }
}

@Composable
@Preview
fun AddChildInfoPreview(){
    AddChildInfo(navController = rememberNavController())
}