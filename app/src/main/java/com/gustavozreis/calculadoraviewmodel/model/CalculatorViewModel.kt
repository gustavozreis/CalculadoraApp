package com.gustavozreis.calculadoraviewmodel.model

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    val displayDigitsList: MutableList<String> = mutableListOf("0123")

    fun appendDigit(digit: String){
        displayDigitsList.add(digit)
    }

    fun displayDigits(displayDigitsList: MutableList<String>): String {
        var digits: String = ""
        for (num in displayDigitsList) {
            digits = "$digits$num"
        }
        return digits
    }

}