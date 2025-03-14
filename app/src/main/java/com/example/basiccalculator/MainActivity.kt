package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //load the calculator fragment
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CalculatorFragment()).commit()
        loadFragment(CalculatorFragment())
    }
    private fun loadFragment(fragment: Fragment) {
        // Create a FragmentManager
        val fm = supportFragmentManager
        // Begin the transaction and replace the Fragment
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit() // Save the changes
    }

}