package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import com.example.jetpackcompose.ui.theme.Shapes

class CardAnimationActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White) {
                    CardAnimation(
                        "Android",
                        description = "You can consider padding and margin as the same thing (imagine it as \"spacing\"). A padding can be applied twice (or more) in the same composable and achieve the similar behavior you would get with margin+padding. For example:"
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun CardAnimation(title: String, description: String, padding: Dp = 20.dp) {
    var expendedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expendedState) 180f else 0f)

    Card(
        onClick = { expendedState = !expendedState },
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .padding(10.dp)
            .animateContentSize(
                animationSpec = tween(durationMillis = 200, easing = LinearOutSlowInEasing)
            ),
        shape = Shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)
                .padding(10.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                IconButton(
                    onClick = { expendedState = !expendedState },
                    modifier = Modifier.rotate(rotationState)
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop down arrow"
                    )

                }


            }
            if (expendedState) {
                Text(text = description)
            }
        }

    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    JetPackComposeTheme {
        CardAnimation(
            "Android",
            description = "You can consider padding and margin as the same thing (imagine it as \"spacing\"). A padding can be applied twice (or more) in the same composable and achieve the similar behavior you would get with margin+padding. For example:"
        )
    }
}