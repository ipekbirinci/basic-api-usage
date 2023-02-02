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

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  SignUpWithImagePrewiev()
                }
            }
        }
    }
}

@Composable
fun SignUpWithImage() {
    val image= painterResource(id = R.drawable.egg_icon)
    var userName by remember{
        mutableStateOf("")

    }
    var userSurname by remember{
        mutableStateOf("")

    }
    var userEmail by remember{
        mutableStateOf("")

    }
    var userTelephone by remember{
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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 80.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                //.fillMaxSize(100f)
                .size(100.dp),
            contentScale= ContentScale.Fit)
        Text("Sign Up!",fontSize=30.sp, modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally))

        OutlinedTextField(value = userName,  label = {
            Text(text = "Name")
        },  onValueChange = {userName= it}, singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp))
        OutlinedTextField(value = userSurname,  label = {
            Text(text = "Surname:")
        },  onValueChange = {userSurname= it}, singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp))
        OutlinedTextField(value = userEmail,  label = {
            Text(text = "e-mail:")
        },  onValueChange = {userEmail= it}, singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp))
        OutlinedTextField(value = userTelephone,  label = {
            Text(text = "Telephone:")
        },  onValueChange = {userTelephone= it}, singleLine = true,
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
        

        Spacer(modifier = Modifier.padding(top = 30.dp))

Button(onClick = { /*TODO*/ },
    modifier=Modifier.padding(start=20.dp,end=20.dp).fillMaxWidth(),
    colors = ButtonDefaults.buttonColors(backgroundColor= androidx.compose.ui.graphics.Color.Red)) {
    Text(text = "Create an Account!", color = Color.White, fontSize = 20.sp)
    
}

    }

}

@Preview(showBackground = true)
@Composable
fun SignUpWithImagePrewiev() {
    LoginPageTheme {
        SignUpWithImage()
    }
}