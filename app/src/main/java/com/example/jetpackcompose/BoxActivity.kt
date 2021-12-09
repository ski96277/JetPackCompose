package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.error) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.Black)){
            Text(text = "Hello Bangladesh", color = Color.White, modifier = Modifier.background(color = Color.Green).fillMaxWidth())

        }

        Box(modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(color = Color.Red)){

        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetPackComposeTheme {
        Greeting("Android")
    }
}