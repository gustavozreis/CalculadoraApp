package com.gustavozreis.calculadoraviewmodel.model

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.gustavozreis.calculadoraviewmodel.MainActivity

class CalculatorViewModel : ViewModel() {

    // Lista que inicia o número mostrado na tela
    val displayDigitsList: MutableList<String> = mutableListOf("")

    // Instancia a lista que vai ser usada para separar os dados
    var tempList: MutableList<String> = mutableListOf("0", "+", "0")

    // Variaveis de entrada para a operação
    var numPrimeiro: Int = 0
    var numSegundo: Int = 0
    var operacao: String = "+"

    // Variável de seguranca para zerar a calculadora apos clilcar em outro numero apos receber
    // resultado
    var numSeguranca: Boolean = false

    // Função que retorna o resultado
    fun resultadoDaOperacao(view: TextView): String {
        var resultado: Long = 0
        val error: String = "error: divided by 0"
        tempList[2] = view.text.toString()

        if (tempList[2] == "") tempList[2] = "0"
        if (tempList[0] == "") tempList[0] = "0"

        if (tempList[2] == "0") {
            numSeguranca = true
            return error
        } else {

            val num1 = tempList[0].toLong()
            val num2 = tempList[2].toLong()

            when (tempList[1]) {
                "+" -> resultado = num1 + num2
                "-" -> resultado = num1 - num2
                "/" -> resultado = num1 / num2
                "*" -> resultado = num1 * num2
            }
            tempList[0] = "0"
            tempList[1] = "+"
            tempList[2] = "0"

            numSeguranca = true
        }
        return resultado.toString()
    }

    fun displayDigits(displayDigitsList: MutableList<String>): String {
        var digits: String = ""
        for (num in displayDigitsList) {
            digits = "$digits$num"
        }
        return digits
    }

}