package com.gustavozreis.calculadoraviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gustavozreis.calculadoraviewmodel.model.CalculatorViewModel
import com.gustavozreis.calculadoraviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null // viewbinding
    private var displayDigits: TextView? = null // declarar variavel do digito que aparece quando app é iniciado
    val viewModel: CalculatorViewModel by viewModels() // instanciar viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //instanciar view binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this@MainActivity // acoplar layout

        displayDigits = binding.tvDisplayDigits
        displayDigits?.text = ""

    }

    // função tem como parametro o texto (número) do botão e adiciona ao final do textview com o número
    fun appendDigit(view: TextView) {
        if (viewModel.numSeguranca == false) {
            displayDigits?.append(view.text)
        } else {
            displayDigits?.text = ""
            viewModel.numSeguranca = false
            displayDigits?.append(view.text)
        }
    }

    // Função que alteram as variáveis de entrada
    fun pegaNumeros(view: TextView) {
        viewModel.tempList[0] = view.text.toString()
    }

    // Função que define o tipo de operação
    fun escolhaDaOperacao(view: TextView) {
        viewModel.tempList[0] = displayDigits?.text.toString()
        displayDigits?.text = ""
        viewModel.tempList[1] = view.text.toString()
    }

    // Função que chama o retorna resultado do ViewModel
    fun resultado() {
        val resultado: Int = viewModel.resultadoDaOperacao(displayDigits as TextView)
        displayDigits?.text = resultado.toString()
    }

    // Função que limpa o numero da tela
    fun clear() {
        viewModel.tempList[0] = ""
        viewModel.tempList[1] = "+"
        viewModel.tempList[2] = "0"
        displayDigits?.text = "0"
    }


}