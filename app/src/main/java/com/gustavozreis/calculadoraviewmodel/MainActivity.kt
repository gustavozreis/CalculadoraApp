package com.gustavozreis.calculadoraviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gustavozreis.calculadoraviewmodel.Model.CalculatorViewModel
import com.gustavozreis.calculadoraviewmodel.Utils.Utils
import com.gustavozreis.calculadoraviewmodel.databinding.ActivityMainBinding
import kotlin.properties.ReadOnlyProperty

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //instanciar view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // instanciar ViewModel
        val viewModel: CalculatorViewModel by viewModels()

        val displayDigits = binding.tvDisplayDigits
        displayDigits.text = viewModel.displayDigits

    }



}