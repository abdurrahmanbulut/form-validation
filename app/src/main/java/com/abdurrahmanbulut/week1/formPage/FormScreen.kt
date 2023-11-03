package com.abdurrahmanbulut.week1.formPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(navController: NavController, viewModel: FormViewModel) {
    val mContext = LocalContext.current

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.input1,
                    onValueChange = { viewModel.updateInput1(it) },
                    isError = viewModel.input1Error.isNullOrEmpty().not()
                )
                viewModel.input1Error.let {
                    Text(text = viewModel.input1Error.toString())
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.input2,
                    onValueChange = { viewModel.updateInput2(it) },
                    isError = viewModel.input2Error.isNullOrEmpty().not()
                )
                viewModel.input2Error.let {
                    Text(text = viewModel.input2Error.toString())
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.input3,
                    onValueChange = { viewModel.updateInput3(it) },
                    isError = viewModel.input3Error.isNullOrEmpty().not()
                )
                viewModel.input3Error.let {
                    Text(text = viewModel.input3Error.toString())
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.input4,
                    onValueChange = { viewModel.updateInput4(it) },
                    isError = viewModel.input4Error.isNullOrEmpty().not()
                )
                viewModel.input4Error.let {
                    Text(text = viewModel.input4Error.toString())
                }
            }

            Button(onClick = { viewModel.onClickButton() }) {
                Text(text = "Validate")
            }
        }

    }
}