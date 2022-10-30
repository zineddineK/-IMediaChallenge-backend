package com.karima.imedia.data


import com.karima.imedia.model.SymbolsResponse
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate


@Repository
class CurrencyRepository(
    private val restTemplate: RestTemplate
) {

    companion object {
        const val SYMBOLS_URL = "https://api.apilayer.com/fixer/symbols?apikey=uS9vZH43DPRrM22XnK92CHhb8eBlRg38"
    }

    fun fetchSymbols(): List<String> {
        val res = restTemplate.getForObject(SYMBOLS_URL, SymbolsResponse::class.java) ?: return emptyList()
        return res.symbols.keys.toList()
    }

}