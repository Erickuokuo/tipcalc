package edu.uw.ischool.erickuokuo.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import java.text.DecimalFormat

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    private lateinit var serviceChargeEditText: EditText
    private lateinit var tipButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceChargeEditText = findViewById(R.id.serviceChargeEditText)
        tipButton = findViewById(R.id.tipButton)

        serviceChargeEditText.addTextChangedListener { text ->
            // Check if the entered text is a valid number and enable the "Tip" button
            val isNumber = text.toString().matches(Regex("^\\d+(\\.\\d{0,2})?$"))
            tipButton.isEnabled = isNumber
        }

        tipButton.setOnClickListener {
            val serviceChargeText = serviceChargeEditText.text.toString()
            val serviceCharge = serviceChargeText.toDoubleOrNull() ?: 0.0
            val tipAmount = serviceCharge * 0.15
            val formattedTip = DecimalFormat("$#.##").format(tipAmount)

            val toastMessage = "Tip: $formattedTip"
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}





