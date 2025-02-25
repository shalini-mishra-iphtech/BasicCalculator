package com.example.basiccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorFragment : Fragment() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView2: TextView // To display selected operator
    private lateinit var resultView: TextView // To display the result
    private lateinit var addBtn: Button
    private lateinit var subBtn: Button
    private lateinit var mulBtn: Button
    private lateinit var divBtn: Button
    private var selectedOperator: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        // Initialize UI elements
        editText1 = view.findViewById(R.id.valueET1)
        editText2 = view.findViewById(R.id.valueET2)
        textView2 = view.findViewById(R.id.textView2)
        resultView = view.findViewById(R.id.result)

        addBtn = view.findViewById(R.id.add)
        subBtn = view.findViewById(R.id.sub)
        mulBtn = view.findViewById(R.id.mul)
        divBtn = view.findViewById(R.id.div)

        // Set click listeners for operator buttons
        addBtn.setOnClickListener { performCalculation("+") }
        subBtn.setOnClickListener { performCalculation("-") }
        mulBtn.setOnClickListener { performCalculation("*") }
        divBtn.setOnClickListener { performCalculation("/") }

        return view
    }

    // Function to set operator and calculate result
    private fun performCalculation(operator: String) {
        val value1 = editText1.text.toString().toDoubleOrNull()
        val value2 = editText2.text.toString().toDoubleOrNull()

        if (value1 == null || value2 == null) {
            resultView.text = "Invalid Input"
            return
        }

        textView2.text = operator // Display the selected operator

        val result = when (operator) {
            "+" -> value1 + value2
            "-" -> value1 - value2
            "*" -> value1 * value2
            "/" -> if (value2 != 0.0) value1 / value2 else "Cannot divide by zero"
            else -> "Error"
        }

        resultView.text = "Result: $result"
    }
}
