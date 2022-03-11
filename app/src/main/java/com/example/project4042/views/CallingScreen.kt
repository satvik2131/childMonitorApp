package com.example.project4042.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CallingScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Text(
            "Incoming Call",
            modifier = Modifier.wrapContentSize(
                align = Alignment.TopCenter
            )
        )

        IconButton(
            onClick = { /*TODO*/ },
            Modifier
                .size(200.dp)
                .border(3.dp, Color.DarkGray, shape = CircleShape)
        ) {
            Icon(Icons.Default.Person, contentDescription = "Caller",Modifier.size(100.dp))
        }


        Row(
            Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green,shape= CircleShape)
//                    .shadow(10.dp)
            ) {
                Icon(Icons.Default.Call, contentDescription = "pick call",Modifier.size(70.dp))
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red,shape= CircleShape)
//                    .shadow(10.dp)


            ) {
                Icon(Icons.Default.Call, contentDescription = "reject call",Modifier.size(70.dp))
            }
        }

    }
}


@Preview
@Composable
fun CallingScreenPreview(){
    CallingScreen()
}