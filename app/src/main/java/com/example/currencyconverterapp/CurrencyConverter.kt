package com.example.currencyconverter

object CurrencyConverter {
    fun convert(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val exchangeRates = CurrencyData.getExchangeRates()

        if (fromCurrency == toCurrency) return amount

        val fromRate = exchangeRates[fromCurrency] ?: 1.0
        val toRate = exchangeRates[toCurrency] ?: 1.0

        return amount * (toRate / fromRate)
    }
}
