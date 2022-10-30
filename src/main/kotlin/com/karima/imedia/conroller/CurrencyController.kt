package com.karima.imedia.conroller

import com.karima.imedia.model.Category
import com.karima.imedia.service.CurrencyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
class CurrencyController(
    private val currencyService: CurrencyService
) {


    @GetMapping("/currencies")
    fun getAll(): ResponseEntity<List<String>> {
        return ResponseEntity.ok(currencyService.readSymbols())
    }

}