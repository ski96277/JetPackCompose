package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme (darkTheme = false){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    ColumnItem(weight = 1f, color = MaterialTheme.colors.onSecondary)
                    ColumnItem(weight = 1f)


                    val context = LocalContext.current
                    val intent = Intent(context,BoxActivity::class.java)

                    Button(onClick = {
                        startActivity(context, intent, null) }
                    ) {
                        Text("Go Box Activity")
                    }


                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(weight = 1f), color = MaterialTheme.colors.secondaryVariant
                    ) {
                        Row {
                            RowItem(weight = 1f)
                            RowItem(weight = 1f, color = Color.Black)

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


            val context = LocalContext.current
            val intent = Intent(context,BoxActivity::class.java)

            Button(onClick = {
                startActivity(context, intent, null) }
            ) {
                Text("Go Box Activity")
            }


            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 1f), color = MaterialTheme.colors.secondaryVariant
            ) {
                Row {
                    RowItem(weight = 1f)
                    RowItem(weight = 1f, color = Color.Black)

                }
            }

        }
    }

}

