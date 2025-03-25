package com.example.currencyconverter

object CurrencyData {
    fun getCurrencies(): Array<String> {
        return arrayOf("USD", "EUR", "VND", "RMB", "KRW")
    }

    fun getExchangeRates(): Map<String, Double> {
        return mapOf(
            "USD" to 1.0,
            "EUR" to 0.85,
            "VND" to 23185.0,
            "RMB" to 7.1,
            "KRW" to 1300.0
        )
    }
}
