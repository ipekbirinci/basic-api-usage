package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class PasswordReset : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
 PasswordResetImagePreview()
                }
            }
        }
    }
}

@Composable
fun PasswordResetImage() {
    val image= painterResource(id = R.drawable.baby_chicken_icon)
    var password by rememberSaveable {
        mutableStateOf("") }
    var passwordtwo by rememberSaveable {
        mutableStateOf("") }

    var passwordVisibility by remember{ mutableStateOf(false
    )
    }
    val icon=if(passwordVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 130.dp)
        , horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                //.fillMaxSize(100f)
                .size(160.dp),
            contentScale= ContentScale.Fit)
        Spacer(modifier = Modifier.padding(top = 40.dp))
        Text("Enter New Password!",fontSize=25.sp, modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally))
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
        OutlinedTextField(value = passwordtwo, onValueChange ={
            passwordtwo=it
        }, placeholder = { Text(text = "Correct Password:")},
            label = { Text(text = "Correct Password:")},
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

        Button(onClick = { /*TODO*/ },
            modifier=Modifier.padding(start=20.dp,end=20.dp).fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor= androidx.compose.ui.graphics.Color.Red)) {
            Text(text = "Done!", color = Color.White, fontSize = 20.sp)

        }

    }

}
@Preview(showBackground = true)
@Composable
fun PasswordResetImagePreview() {
    LoginPageTheme {
PasswordResetImage()
    }
}