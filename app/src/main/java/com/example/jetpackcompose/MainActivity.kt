package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
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

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                androidx.compose.material.Surface(color = Color.White) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        ColumnItem(weight = 1f, color = MaterialTheme.colors.onSecondary)
                        ColumnItem(weight = 1f)
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(weight = 1f), color = MaterialTheme.colors.secondaryVariant
                        ) {
                            Row {
                                RowItem(weight = 1f)
                                RowItem(weight = 1f,color = Color.Black)

                            }
                        }

                    }
                }

            }
        }
    }
}


@Composable
fun ColumnScope.ColumnItem(color: Color = MaterialTheme.colors.primary, weight: Float) {
    Surface(
        modifier = Modifier
            .width(50.dp)
            .weight(weight = weight), color = color
    ) { }
}
@Composable
fun RowScope.RowItem(weight: Float,color: Color=Color.Gray){
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .weight(weight = weight),
        color = color
    ) {

    }
}

@Preview(showBackground = true)
@Composable

fun DefaultPreview() {
    JetPackComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            ColumnItem(weight = 1f, color = MaterialTheme.colors.onSecondary)
            ColumnItem(weight = 1f)
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 1f), color = MaterialTheme.colors.secondaryVariant
            ) {
                Row {
                    RowItem(weight = 1f)
                    RowItem(weight = 1f,color = Color.Black)

                }
            }

        }
    }

}

