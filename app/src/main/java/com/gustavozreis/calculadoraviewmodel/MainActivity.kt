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

    private var binding: ActivityMainBinding? = null
    private var displayDigits: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //instanciar view binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this@MainActivity

        // instanciar ViewModel
        val viewModel: CalculatorViewModel by viewModels()

        displayDigits = binding.tvDisplayDigits
        displayDigits?.text = viewModel.displayDigitsList[0]



    }

    fun appendDigit(view: TextView) {
        displayDigits?.append(view.text)
        Toast.makeText(this, "funcao chamada", Toast.LENGTH_LONG).show()
    }





}