package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class TextCustomizationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                Column(
                    modifier = Modifier
                        .background(color = Color.Cyan)
                        .fillMaxSize()
                ) {
                    CustomStringText()

                    CustomAnnotatedText()

                    CustomText()

                }
            }
        }
    }
}

@Composable
fun CustomStringText() {

    Text(
        text = stringResource(id = R.string.app_name), modifier = Modifier
            .background(color = Color.Green)
            .padding(10.dp)
            .background(color = Color.Black),
        color = Color.White,
        fontSize = 35.sp,
        fontWeight = FontWeight.Thin
    )
}

@Composable
fun CustomAnnotatedText() {

    Text(

        buildAnnotatedString {

            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 45.sp)) {

                    append("A")
                }
            }

            withStyle(style = SpanStyle(color = Color.Blue, fontSize = 55.sp)) {

                append("b")
            }
            append("c")
            append("d")
        }, modifier = Modifier.width(250.dp)
    )
}

@Composable
fun CustomText(){
    Text(text = "hello imran ".repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetPackComposeTheme {
        Column(
            modifier = Modifier
                .background(color = Color.Cyan)
                .fillMaxSize()
        ) {
            CustomStringText()

            CustomAnnotatedText()

            CustomText()

        }
    }
}