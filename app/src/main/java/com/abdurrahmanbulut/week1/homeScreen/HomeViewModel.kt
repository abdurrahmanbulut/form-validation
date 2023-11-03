package com.abdurrahmanbulut.week1.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel :ViewModel(){

    var number by mutableStateOf("")
    var numOfStep by mutableStateOf("0")
    var showText by mutableStateOf(false)

    fun week1Foo(number: Int): Int {

        if(number <= 1){
            return 0
        }

        return 1 + if(number % 2 == 0) week1Foo(number / 2) else week1Foo(number * 3 + 1)
    }

}