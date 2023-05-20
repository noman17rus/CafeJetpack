package com.example.cafejetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafejetpack.ui.theme.CafeJetpackTheme
import com.example.cafejetpack.ui.theme.Purple40
import com.example.cafejetpack.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(1f)) {
        Row(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AddLogoImage()
        }
        Row(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth(1f),
            verticalAlignment = Alignment.Bottom
        ) {
            Column() {
                Text(
                    text = "Welcome to donut shop",
                    modifier = modifier
                        .weight(1f)
                        .fillMaxWidth(1f),
                    fontFamily = FontFamily.Cursive,
                    fontSize = 40.sp,
                    color = Purple40,
                    textAlign = TextAlign.Center
                )
                Column(modifier = modifier.fillMaxWidth(1f)) {
                    AddTextEdit(modifier = Modifier, "Enter first name")
                    AddTextEdit(modifier = Modifier, "Enter second name")
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxWidth(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "Login")
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CafeJetpackTheme {
        LoginScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTextEdit(modifier: Modifier, placeholderMsg: String) {
    val textState = remember { mutableStateOf("") }
    OutlinedTextField(
        value = textState.value,
        onValueChange = {
            textState.value = it.trim()
        },
        placeholder = {
            Text(text = placeholderMsg)
        },
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(10.dp),
        textStyle = TextStyle(fontSize = 20.sp),
    )
}

@Composable
fun AddLogoImage() {
    Image(
        painter = painterResource(id = R.drawable.donut), contentDescription = "Image",
        modifier = Modifier.fillMaxWidth(1f),
        alignment = Alignment.BottomCenter
    )
}