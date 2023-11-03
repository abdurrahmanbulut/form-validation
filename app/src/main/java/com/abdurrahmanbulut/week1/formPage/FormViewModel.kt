package com.abdurrahmanbulut.week1.formPage

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {

    var input1 by mutableStateOf("")
    var input2 by mutableStateOf("")
    var input3 by mutableStateOf("")
    var input4 by mutableStateOf("")

    var input1Error by mutableStateOf("")
    var input2Error by mutableStateOf("")
    var input3Error by mutableStateOf("")
    var input4Error by mutableStateOf("")

    fun updateInput1(state: String) {
        println(state)
        if (state.isEmpty()) {
            input1 = ""
        } else if (state.matches("^[a-zA-Z ]+\$".toRegex()))
            input1 = state
    }

    fun updateInput2(state: String) {
        if (state.isEmpty()) {
            input2 = ""
        } else if (state.contains('-').not() && state.toIntOrNull() != null) {
            input2 = state
        }
    }

    fun updateInput3(state: String) {
        if (state.isEmpty()) {
            input3 = ""
        } else if (state.contains('-').not() && state.toIntOrNull() != null)
            input3 = state
    }

    fun updateInput4(state: String) {
        input4 = state
    }

    fun onClickButton(){

        val result = validate2()

        input1Error = result.inputError1 ?: ""
        input2Error = result.inputError2 ?: ""
        input3Error = result.inputError3 ?: ""
        input4Error = result.inputError4 ?: ""

        if (result.isSuccessful){
            // TO-do event to screen
        }

    }
    fun validate2(): ValidationClass {


        // Input1
        var input1Error: String? = null
        var input2Error: String? = null
        var input3Error: String? = null
        var input4Error: String? = null

        var input2Val: Int = 0
        var input3Val: Int = 0

        if (input2.isNotEmpty() && input3.isNotEmpty()){
            input2Val = input2.toInt()
            input3Val = input3.toInt()
        }

        if (input1.isEmpty()) {
            input1Error = "It cannot be empty!"
        }


        input1.split(' ').forEach { word ->

            word.forEachIndexed { index, char ->

                if (index == 0 && char.isLowerCase()) {
                    input1Error = "First character of each word should be uppercase!"
                }
                else if (index != 0 && char.isUpperCase()) {
                    input1Error =
                        "Other characters except first one of each word should be lowercase!"
                }
            }
        }

        //Input2
        if (input2.isEmpty()) {
            input2Error = "It cannot be empty!"
        }

        if (input3Val <= (input2Val * (input2Val + 1)) / 2) {
            input2Error = "Validation 2 Error"
        }


        //Input4
        if (input4.isEmpty()) {
            input4Error = "It cannot be empty!"
        }

        input4.forEachIndexed { index, c ->
            if (index < input4.length / 2) {
                if (c != input4[input4.length - index - 1]) {
                    input4Error = "It is not palindrome!"
                }
            }
        }
        return ValidationClass(
            isSuccessful = input1Error.isNullOrEmpty() && input2Error.isNullOrEmpty() && input3Error.isNullOrEmpty() && input4Error.isNullOrEmpty(),
            inputError1 = input1Error,
            inputError2 = input2Error,
            inputError3 = input3Error,
            inputError4 = input4Error,
        )
    }

    fun validate(context: Context): Boolean {

        var validation: Boolean = true

        input1Error = ""
        input2Error = ""
        input3Error = ""
        input4Error = ""

        if (input1.isEmpty()) {
            input1Error = "It cannot be empty!"
            validation = false
        }

        if (input2.isEmpty()) {
            input2Error = "It cannot be empty!"
            validation = false
        }

        if (input3.isEmpty()) {
            input3Error = "It cannot be empty!"
            validation = false
        }

        if (input4.isEmpty()) {
            input4Error = "It cannot be empty!"
            validation = false
        }

        if (validation.not()) {
            return false
        }

        val input2Val: Int = input2.toInt()
        val input3Val: Int = input3.toInt()

        // input 1
        input1.split(' ').forEach { word ->
            word.forEachIndexed { index, char ->
                if (index == 0 && char.isLowerCase()) {
                    println(input1Error)
                    input1Error = "First character of each word should be uppercase!"
                    validation = false
                } else if (index != 0 && char.isUpperCase()) {
                    input1Error =
                        "Other characters except first one of each word should be lowercase!"
                    validation = false
                }
            }
        }

        // val 2
        if (input3Val <= (input2Val * (input2Val + 1)) / 2) {
            input2Error = "Validation 2 Error"
            validation = false
        }

        //val 3
        // zaten pozitif int girilebiliyor sadece

        //val 4
        input4.forEachIndexed { index, c ->
            if (index < input4.length / 2) {
                if (c != input4[input4.length - index - 1]) {
                    input4Error = "It is not palindrome!"
                    validation = false
                }
            }
        }

        if (validation) {
            Toast.makeText(context, "Validation Successful", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Validation Failure", Toast.LENGTH_LONG).show()
        }

        return validation
    }
}

data class ValidationClass(
    val isSuccessful: Boolean,
    val inputError1: String?,
    val inputError2: String?,
    val inputError3: String?,
    val inputError4: String?
) {}


















