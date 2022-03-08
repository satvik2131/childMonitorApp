package com.example.project4042

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.project4042.ui.theme.Project4042Theme

class MainActivity : ComponentActivity() {

    var context: Context? = null;
    private val REQUEST_CODE_GOOGLE_SIGN_IN = 1 /* unique request id */
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = applicationContext

        setContent {
            Project4042Theme {
                MainContent()

            }
        }
    }

}
