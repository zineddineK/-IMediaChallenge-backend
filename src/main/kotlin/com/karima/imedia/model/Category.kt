package com.karima.imedia.model

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    val name: String,
    @ManyToOne
    val parent: Category? = null
) {
    constructor() : this(
        id = 0,
        name = ""
    )
}
