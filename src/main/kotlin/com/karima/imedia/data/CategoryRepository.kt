package com.karima.imedia.data

import com.karima.imedia.model.Category
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: CrudRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.parent is null")
    fun findMainCategories(): Iterable<Category>

    fun findCategoriesByParentId(id : Long): Iterable<Category>
}