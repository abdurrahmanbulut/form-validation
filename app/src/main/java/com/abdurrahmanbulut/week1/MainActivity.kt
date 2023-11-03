package com.abdurrahmanbulut.week1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdurrahmanbulut.week1.formPage.FormScreen
import com.abdurrahmanbulut.week1.homeScreen.HomeScreen
import com.abdurrahmanbulut.week1.ui.theme.Week1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Week1()
        }
    }
}

@Composable
fun Week1(){
    val navController = rememberNavController()

    Week1Theme {
        NavHost(navController = navController, startDestination = "home"){
            composable("home"){ HomeScreen(navController, viewModel = viewModel()) }
            composable("form"){ FormScreen(navController, viewModel = viewModel()) }
        }
    }
}

