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
        displayDigits?.text = "0"

    }

    // função tem como parametro o texto (número) do botão e adiciona ao final do textview com o número
    fun appendDigit(view: TextView) {
        displayDigits?.append(view.text)
        Toast.makeText(this, "funcao chamada", Toast.LENGTH_LONG).show()
    }

    // Função que alteram as variáveis de entrada
    fun pegaNumeros(view: TextView) {
        viewModel.tempList.add(view.text.toString())
    }

    // Função que define o tipo de operação
    fun escolhaDaOperacao(view: TextView) {
        viewModel.tempList.add(displayDigits.toString())
        viewModel.tempList.add(view.text.toString())
        displayDigits?.text = ""
    }

    // Função que chama o retorna resultado do ViewModel
    fun resultado() {
        val resultado: String = viewModel.resultadoDaOperacao(displayDigits as TextView)
        displayDigits?.text = resultado
    }


}