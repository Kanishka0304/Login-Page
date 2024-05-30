package com.example.sign_up

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sign_up.ui.theme.Sign_upTheme
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sign_upTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    NavGraph()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    val phone = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF3573CC),
                        fontSize = 30.sp
                    )
                ){
                    append("Work")
                }
                append("Ngine")
            },
            fontSize = 30.sp,
            color = Color.White,
            textAlign= TextAlign.Start,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(alignment = Alignment.Start)
        )
        Text(
            text = "Login",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        Text(
            text = "Please enter your Mobile Number and Password to login into your account.",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(bottom = 80.dp)
                .align(alignment = Alignment.Start)
        )
        TextField(
            value = phone.value,
            onValueChange = { phone.value = it },
            label = { Text("Phone") },
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        )
        val annotatedText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFF3573CC), textDecoration = TextDecoration.Underline)) {
                append("Forgot Password?")
            }
        }
        val context = LocalContext.current
        ClickableText(
            text = annotatedText,
            onClick = {
                Toast.makeText(context,"", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {},
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        {
            Text(text = "Login",
                color = Color.White)
        }
        Button(onClick = {},
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        {
            Text(text = "Sign in with Google",
                color=Color.White)
        }
        Row {
            Text(text = "Don't have an account?",
                color = Color.White)

            val annotatedText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF3573CC), textDecoration = TextDecoration.Underline)) {
                    append("Register")
                }
            }
            Spacer(modifier = Modifier.width(15.dp))
            val context = LocalContext.current
            ClickableText(
                text = annotatedText,
                onClick = {
                    navController.navigate("register")
                    Toast.makeText(context,"", Toast.LENGTH_SHORT).show()
                },
            )
        }
    }
}

