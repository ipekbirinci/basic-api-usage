package com.example.loginpage

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.R
import com.example.loginpage.ui.theme.LoginPageTheme
//import com.ipekbi.loginpage.ui.theme.LoginPageTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginPageWithImagePreview()
                }
            }
        }
    }
}


@Composable
fun LoginPageWithImage() {
    var textFieldState by remember{
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false
    )}
    val icon=if(passwordVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)
    val scope= rememberCoroutineScope()
    val image= painterResource(id = R.drawable.chicken_icon)
    val emailimage= painterResource(id = R.drawable.baseline_email_24)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 120.dp)
        , horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                //.fillMaxSize(100f)
                .size(160.dp),
            contentScale= ContentScale.Fit)
        Spacer(modifier = Modifier.padding(top = 40.dp))
        Text("Welcome!",fontSize=30.sp, modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(top = 10.dp))
        OutlinedTextField(value = textFieldState,
            label = {
                Text(text = "Enter your e-mail:")
            }, trailingIcon =  {
                Icon(painter =emailimage, contentDescription =null )

            }, onValueChange = {textFieldState= it}, singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp))
        OutlinedTextField(value = password, onValueChange ={
            password=it
        }, placeholder = { Text(text = "Password:")},
            label = { Text(text = "Password:")},
            trailingIcon = {
                IconButton(onClick = { passwordVisibility=!passwordVisibility }) {
                    Icon(painter = icon, contentDescription ="Visibility Icon" )

                }
            },
            visualTransformation = if(passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation() ,
            modifier= Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp))

        Spacer(modifier = Modifier.padding(top = 15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

            Button(onClick = {

        //dashboard olmalı

                             }
                ,modifier=Modifier.padding(end=10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor= androidx.compose.ui.graphics.Color.Red)) {

                Text(text = "Sign In", color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 20.sp )

            }
            ClickableText(text = AnnotatedString("Forgot Password?"),
                onClick = {

                })

        }
        ClickableText(text = AnnotatedString("New to Application? Sign Up."),
            modifier = Modifier.padding(top=70.dp),
            onClick = {


            })
    }

}

@Preview( showBackground = true)
@Composable
fun LoginPageWithImagePreview() {
    LoginPageTheme {
        LoginPageWithImage()
    }
}