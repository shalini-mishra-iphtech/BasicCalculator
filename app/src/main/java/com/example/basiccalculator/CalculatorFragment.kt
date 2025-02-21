package com.example.basiccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView



class CalculatorFragment : Fragment() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView1: TextView
    private lateinit var addBtn: Button
    private lateinit var subBtn: Button
    private lateinit var mulBtn: Button
    private lateinit var divBtn: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
//        editText1=view.findViewById(R.id.valueET1)
//        editText2=view.findViewById(R.id.valueET2)
//        textView1=view.findViewById(R.id.result)

        editText1=view.findViewById(R.id.valueET1)
        editText2 = view.findViewById(R.id.valueET2)
        textView1 = view.findViewById(R.id.result)
        addBtn= view.findViewById(R.id.add)
        subBtn = view.findViewById(R.id.sub)
        mulBtn= view.findViewById(R.id.mul)
        divBtn = view.findViewById(R.id.div)

        fun addNumbers() {
            val value1 = editText1.text.toString().toIntOrNull() ?: 0
            val value2 = editText2.text.toString().toIntOrNull() ?: 0
            val result = value1 + value2
            textView1.text = result.toString()
        }

        // Set click listener inside the function
        addBtn.setOnClickListener {
            addNumbers()
        }
        fun subNumbers() {
            val value1 = editText1.text.toString().toIntOrNull() ?: 0
            val value2 = editText2.text.toString().toIntOrNull() ?: 0
            val result = value1 - value2
            textView1.text = result.toString()
        }

        // Set click listener inside the function
        subBtn.setOnClickListener {
            subNumbers()
        }

        fun mulNumbers() {
            val value1 = editText1.text.toString().toIntOrNull() ?: 0
            val value2 = editText2.text.toString().toIntOrNull() ?: 0
            val result = value1 * value2
            textView1.text = result.toString()
        }

        // Set click listener inside the function
        mulBtn.setOnClickListener {
            mulNumbers()
        }

        fun divNumbers() {
            val value1 = editText1.text.toString().toIntOrNull() ?: 0
            val value2 = editText2.text.toString().toIntOrNull() ?: 0

            if(value2==0){
                val result="infinite"
                textView1.text=result

            }
            else {
                val result = value1 / value2
                textView1.text = result.toString()
            }
        }

        // Set click listener inside the function
        divBtn.setOnClickListener {
            divNumbers()
        }
        return view




    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI elements




    }
}
