package com.karima.imedia.model

data class SymbolsResponse(
    val success: Boolean,
    val symbols: HashMap<String, String>
) {
    constructor(): this(true, HashMap())
}
