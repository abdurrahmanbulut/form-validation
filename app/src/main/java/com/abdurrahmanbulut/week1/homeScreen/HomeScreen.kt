package com.abdurrahmanbulut.week1.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Column (
                modifier = Modifier
                    .fillMaxHeight(0.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                TextField(modifier = Modifier.background(color = Color.White) ,value = viewModel.number, onValueChange = {
                    viewModel.number = it
                    viewModel.showText = false
                })

                if (viewModel.showText){
                    Text(
                        text = "number ${viewModel.number} has number of ${viewModel.numOfStep} steps to access 1",
                    )
                }
                else{
                    Text(
                        text = "Enter a number and press \"Calculate\" button",
                    )
                }


                Button(onClick = { viewModel.numOfStep =
                    viewModel.week1Foo(viewModel.number.toInt()).toString()
                    viewModel.showText = true
                }) {
                    Text(text = "Calculate")
                }
            }


            Button(modifier = Modifier.padding(top = 40.dp) ,onClick = { navController.navigate("form") }) {
                Text(text = "Go To Form Page")
            }
        }

    }
}


