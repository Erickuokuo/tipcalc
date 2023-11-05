package edu.uw.ischool.erickuokuo.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var serviceChargeEditText: EditText
    private lateinit var tipButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceChargeEditText = findViewById(R.id.serviceChargeEditText)
        tipButton = findViewById(R.id.tipButton)

        tipButton.setOnClickListener {
            calculateTip()
        }

        serviceChargeEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input = s.toString()
                tipButton.isEnabled = isValidNumber(input)
            }

    override fun afterTextChanged(s: Editable?) {}
        })
    }
    private fun isValidNumber(input: String): Boolean {
        // Regular expression to check if the input is a valid decimal number.
        return input.matches("^\\$\\d{1,}(\\.\\d{0,2})?$".toRegex())
    }

    private fun calculateTip() {
        val input = serviceChargeEditText.text.toString()
        val numericValue = input.replace("[^\\d.]".toRegex(), "")
        val serviceCharge = numericValue.toDouble()

        val tipAmount = serviceCharge * 0.15

        val df = DecimalFormat("$0.00")
        val formattedTip = df.format(tipAmount)

        Toast.makeText(this, "Tip Amount: $formattedTip", Toast.LENGTH_SHORT).show()
    }
}





