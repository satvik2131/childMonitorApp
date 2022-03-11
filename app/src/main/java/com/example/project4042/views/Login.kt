package com.example.project4042

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("RestrictedApi")
@Composable
fun LoginWithGoogle(navController: NavController){

    val context = LocalContext.current

    //Authorization************************
//    var userAuth = AuthUI.getInstance()
//    var user = userAuth.auth.currentUser
//
//    if(user!==null){
//        navController.navigate("Homepage")
//    }
    //***************************************

    FirebaseApp.initializeApp(context)
    // Equivalent of onActivityResult
    val launcher = rememberLauncherForActivityResult(contract = FirebaseAuthUIActivityResultContract()) {
        res -> onSignInResult(res,navController)
    }

    // Choose authentication providers
    val providers = arrayListOf(
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            OutlinedButton(
                border = ButtonDefaults.outlinedBorder.copy(width = 1.dp),
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp),
                onClick = {

                    // Create and launch sign-in intent
                    val signInIntent = AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build()
                    launcher.launch(signInIntent)

                },
            ){
                Text("Login As Parent")
            }
        }
}

fun onSignInResult(result: FirebaseAuthUIAuthenticationResult?,navController: NavController) {

    //Successfully login

    val response = result?.idpResponse
    if (result?.resultCode == RESULT_OK) {
        // Successfully signed in
        val user = FirebaseAuth.getInstance().currentUser
        navController.navigate("homepage");
    } else {

    // Sign in failed. If response is null the user canceled the
        // sign-in flow using the back button. Otherwise check
        // response.getError().getErrorCode() and handle the error.
    }
}

@Composable
@Preview
fun LoginWithGooglePreview(){
    LoginWithGoogle(navController = rememberNavController())
}

