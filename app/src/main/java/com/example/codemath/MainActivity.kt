package com.example.codemath

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.codemath.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting up ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Function to perform the calculation
        fun calculateResult() {
            val input1 = binding.inputField1.text.toString().toDoubleOrNull()
            val input2 = binding.inputField2.text.toString().toDoubleOrNull()

            if (input1 != null && input2 != null) {
                // Example calculation: multiplication
                val result = input1 * input2
                binding.resultView.text = "Result: $result"
            } else {
                binding.resultView.text = "Please enter valid numbers."
            }
        }

        // TextWatcher to automatically update results
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                calculateResult()
            }
        }

        // Adding TextWatcher to both input fields
        binding.inputField1.addTextChangedListener(textWatcher)
        binding.inputField2.addTextChangedListener(textWatcher)

        // Button click listener to perform the calculation manually
        binding.calculateButton.setOnClickListener {
            calculateResult()
        }
    }
}
