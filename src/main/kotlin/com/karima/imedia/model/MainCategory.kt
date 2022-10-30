package com.karima.imedia.model


data class MainCategory(
    val id: Long,
    val name: String,
    val children: List<Category>
) {
    constructor(): this(0, "", emptyList())
}
