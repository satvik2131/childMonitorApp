package com.example.project4042

import android.annotation.SuppressLint
import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Homepage(navController: NavController){
    var context = LocalContext.current
    var hours by remember { mutableStateOf(value = "")}
    var expanded by remember { mutableStateOf(false) }
    var modeValue by remember { mutableStateOf("")}

    Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


        //Select your mode for fooling the kid
        Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {

            OutlinedButton(onClick = { expanded = true }) {
                Text("Choose your mode")
            }


            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(onClick = {
                    modeValue = "Call Screen"
                }) {
                    Text("Call Screen")
                }
                DropdownMenuItem(onClick = {
                    modeValue = "Lock the phone"

                }) {
                    Text("Battery Low")

                }
                Divider()
                DropdownMenuItem(onClick = {
                    modeValue = "Lock the phone"

                }) {
                    Text("Lock the phone")

                }
            }
        }



        //Enter Timeout Hours
        OutlinedTextField(
                placeholder = {Text("Enter Timeout Hours")},
                value=hours,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                                hours = it
                },
                )

            Button(
                onClick = {
                          checkAndLaunchTheMode(modeValue,navController)
                },
            ) {
                Text("start countdown", color = Color.White)
            }
        }
    }

//Check and launch the selected mode activity
fun checkAndLaunchTheMode(modeValue:String,navController: NavController){
    Log.d("jjj=----",modeValue)
    if(modeValue==="Call Screen"){

        val handler = Handler()
        handler.postDelayed(Runnable {
            navController.navigate("callingScreen")
        }, 20000)

    }else if(modeValue==="Battery Low"){

    }else{

    }
}


//take current time and set an trigger for the timeout
@RequiresApi(Build.VERSION_CODES.N)
fun chooseTimeToLockPhone(hours:String, context:Context) {
    Log.d("hours---",hours);


//    val handler = Handler()
//    handler.postDelayed(Runnable {
        var devicePolicyManager =  context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
//        devicePolicyManager.lockNow();
        var mComponentName = ComponentName(context, MyAdminReceiver::class.java)

    val isAdmin: Boolean = devicePolicyManager.isAdminActive(mComponentName)
//    devicePolicyManager.setDeviceOwnerLockScreenInfo(mComponentName,"Working")
    if (isAdmin) {
        devicePolicyManager.lockNow()
    } else {
        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        val compName = ComponentName(context, MyAdminReceiver::class.java)
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName)
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "hola")
        var options:Bundle = Bundle()


    //
    }
//    }, 2000)
}




@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview
fun HomepagePreview(){
    Homepage(navController = rememberNavController())
}