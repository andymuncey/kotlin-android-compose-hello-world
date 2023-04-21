package com.tinyappco.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetByButton()
        }
    }


    @Preview
    @Composable
    fun Greet() {
        Text("Hello World")
    }

    @Preview
    @Composable
    fun GreetByButton() {

        var visible by remember { mutableStateOf(false) }

        Column  {
            Button(onClick = { visible = true}) {
                Text("Press Me")
            }
            if (visible) {
                Text(text = "Hello World")
            }
        }
    }


    @Preview
    @Composable
    fun GreetByName(){

        //keeps track of text in TextField. Can only exist inside composable function
        var text by remember { mutableStateOf("") }

        //text to be displayed
        var displayText by remember { mutableStateOf("") }

        Column {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Type your name") }
                //modifier = Modifier.fillMaxWidth()
            )
           // Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { displayText = text  }
                //modifier = Modifier.fillMaxWidth()
            ) {
                Text("Greet")
            }
           // Spacer(modifier = Modifier.height(16.dp))
            if (displayText.isNotEmpty()) {
                Text("Hello $displayText")
            }
        }
    }

    @Preview
    @Composable
    fun GreetByNamePretty(){

        //keeps track of text in TextField
        var liveText by remember { mutableStateOf("") }

        //text to be displayed
        var name by remember { mutableStateOf("") }

        Column(
              modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = liveText,
                onValueChange = { liveText = it },
                label = { Text("Type your name") },
                modifier = Modifier.fillMaxWidth()
            )
             Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { name = liveText  },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Greet")
            }
             Spacer(modifier = Modifier.height(16.dp))
            if (name.isNotEmpty()) {
                Text("Hello $name")
            }
        }
    }



    
    
}

