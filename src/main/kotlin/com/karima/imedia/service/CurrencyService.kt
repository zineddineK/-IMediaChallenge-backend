package com.karima.imedia.service

import com.karima.imedia.data.CurrencyRepository
import org.springframework.stereotype.Service

@Service
class CurrencyService(
    private val currencyRepository: CurrencyRepository
) {

    fun readSymbols(): List<String> {
        return currencyRepository.fetchSymbols()
    }

}