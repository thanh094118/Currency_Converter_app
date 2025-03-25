package com.example.currencyconverter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAmount = findViewById<EditText>(R.id.editTextAmount)
        val spinnerFrom = findViewById<Spinner>(R.id.spinnerFrom)
        val spinnerTo = findViewById<Spinner>(R.id.spinnerTo)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        val currencyList = CurrencyData.getCurrencies()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencyList)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        buttonConvert.setOnClickListener {
            val amountText = editTextAmount.text.toString()
            if (amountText.isEmpty()) {
                Toast.makeText(this, "Nhập số tiền cần chuyển đổi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toDouble()
            val fromCurrency = spinnerFrom.selectedItem.toString()
            val toCurrency = spinnerTo.selectedItem.toString()

            val result = CurrencyConverter.convert(amount, fromCurrency, toCurrency)
            textViewResult.text = "Kết quả: %.2f %s".format(result, toCurrency)
        }
    }
}
