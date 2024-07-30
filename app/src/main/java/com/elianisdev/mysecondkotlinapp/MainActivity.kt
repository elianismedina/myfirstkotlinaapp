package com.elianisdev.mysecondkotlinapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import com.elianisdev.mysecondkotlinapp.ui.theme.MySecondKotlinAppTheme
import com.elianisdev.mysecondkotlinapp.ui.theme.color1
import com.elianisdev.mysecondkotlinapp.ui.theme.color2
import com.elianisdev.mysecondkotlinapp.ui.theme.color3
import com.elianisdev.mysecondkotlinapp.ui.theme.color4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //defines the activity's layout where composable functions are called
        setContent {
            MySecondKotlinAppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoginScreen()
                }
            }
        }
    }
}
@Composable
fun LoginScreen(){
    //Variables to store the email and password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val gradientColorList = listOf(
        Color(0xFF00BFA5),
        Color(0xFF00B8D4),
        Color(0xFF0097A7),
        Color(0xFF006064)
    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBackgroundBrush(isVerticalGradient = true, colors = gradientColorList ))
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.planet),
            contentDescription = "Login Image",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Bienvenido!",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            color = color3
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = "Inicia sesión en tu cuenta",
            color = color3)
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Correo electrónico") },
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = color2,
                unfocusedLeadingIconColor = color2,

                focusedLabelColor = color3,
                unfocusedLabelColor = color3,

                focusedContainerColor = color3,
                unfocusedContainerColor = color3,

                focusedIndicatorColor = color4,
                unfocusedIndicatorColor = color4,

                unfocusedPlaceholderColor = color4,
                focusedPlaceholderColor = color4

                ), leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email" )

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.size(6.dp))
        OutlinedTextField(
            value = password ,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Contraseña")
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = color2,
                unfocusedLeadingIconColor = color2,

                focusedLabelColor = color3,
                unfocusedLabelColor = color3,

                focusedContainerColor = color3,
                unfocusedContainerColor = color3,

                focusedIndicatorColor = color4,
                unfocusedIndicatorColor = color4,

                unfocusedPlaceholderColor = color4,
                focusedPlaceholderColor = color4



                ), leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password" )

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        GradientButton(
            onClick = {Log.i("Credential", "Email: $email, Password: $password")},
            text = "Iniciar sesión",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    color1,
                    color2
                )
            )
        )
        Spacer(modifier = Modifier.size(6.dp))
        Text(text = "¿Olvidaste tu contraseña?",
            color = color3,
            modifier = Modifier.clickable {
                //Forgot password
            })
        Spacer(modifier = Modifier.size(32.dp))
        Text(text = "O inicia sesión con", color = color3)

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.facebook_color_svgrepo_com),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //Facebook login
                    })
            Image(painter = painterResource(id = R.drawable.google_color_svgrepo_com),
                contentDescription = "Google",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //Google login
                    })
            Image(painter = painterResource(id = R.drawable.twitter_color_svgrepo_com),
                contentDescription = "Twitter",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //Twitter login
                    })

        }

    }

}
@Composable
fun gradientBackgroundBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>,
): Brush {
    val endOffset = if (isVerticalGradient){
        Offset(x = 0f, y = Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 0f)
    }
    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )

}
//Preview function to display the UI
@Preview( showBackground = true)
@Composable
fun LoginPreview(){
    LoginScreen()

}