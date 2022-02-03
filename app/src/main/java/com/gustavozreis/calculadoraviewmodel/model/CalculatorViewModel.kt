package com.gustavozreis.calculadoraviewmodel.model

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.gustavozreis.calculadoraviewmodel.MainActivity

class CalculatorViewModel : ViewModel() {

    // Lista que inicia o número mostrado na tela
    val displayDigitsList: MutableList<String> = mutableListOf("")

    // Instancia a lista que vai ser usada para separar os dados
    var tempList: MutableList<String> = mutableListOf("0","+","0")

    // Variaveis de entrada para a operação
    var numPrimeiro: Int = 0
    var numSegundo: Int = 0
    var operacao: String = ""

    // Função que retorna o resultado
    fun resultadoDaOperacao(view: TextView): Int {
        var resultado: Int = 0
        tempList.add(view.text.toString())
        if (tempList[2] == "") tempList[2] = "0"
        if (tempList[0] == "") tempList[0] = "0"
        when (tempList[1]) {
            "+" -> resultado = tempList[0].toInt() + tempList[2].toInt()
            "-" -> resultado = tempList[0].toInt() - tempList[2].toInt()
            "/" -> resultado = tempList[0].toInt() * tempList[2].toInt()
            "*" -> resultado = tempList[0].toInt() / tempList[2].toInt()
        }
        tempList.clear()
        return resultado
    }


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