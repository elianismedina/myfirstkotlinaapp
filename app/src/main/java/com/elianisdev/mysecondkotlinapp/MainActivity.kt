package com.elianisdev.mysecondkotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.elianisdev.mysecondkotlinapp.ui.theme.MySecondKotlinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //defines the activity's layout where composable functions are called
        setContent {
            MySecondKotlinAppTheme {
            }
        }
    }
}




