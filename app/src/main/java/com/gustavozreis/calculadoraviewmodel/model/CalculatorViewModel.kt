package com.gustavozreis.calculadoraviewmodel.model

import androidx.lifecycle.ViewModel
import com.gustavozreis.calculadoraviewmodel.MainActivity

class CalculatorViewModel : ViewModel() {

    val displayDigitsList: MutableList<String> = mutableListOf("0123")

    fun appendDigit(): Unit{

    }

    fun displayDigits(displayDigitsList: MutableList<String>): String {
        var digits: String = ""
        for (num in displayDigitsList) {
            digits = "$digits$num"
        }
        return digits
    }

}