package com.karima.imedia.model

import javax.persistence.*

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    val title: String,
    val price: Int,
    val currency: String,
    @ManyToOne
    val category: Category
) {
    constructor() : this(
        id =  0,
        title =  "",
        price =  0,
        currency =  "",
        category = Category()
    )
}