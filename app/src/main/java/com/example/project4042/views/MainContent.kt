package com.example.project4042

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project4042.views.CallingScreen


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login"){
                LoginWithGoogle(navController)
            }

            composable("homepage"){
                Homepage(navController = navController)
            }

            composable("callingScreen"){
                CallingScreen()
            }

        }
    }
}

@Preview
@Composable
fun MainPreview() {
    MainContent()
}