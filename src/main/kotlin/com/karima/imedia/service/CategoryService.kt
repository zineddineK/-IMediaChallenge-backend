package com.karima.imedia.service

import com.karima.imedia.data.CategoryRepository
import com.karima.imedia.model.Category
import com.karima.imedia.model.MainCategory
import org.jboss.jandex.Main
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    
    fun readAllCategories(): List<Category> {
        return categoryRepository.findAll().toList()
    }

    fun readMainCategories(): List<MainCategory> {
        val mainCats = categoryRepository.findMainCategories().toList()
        val out = mutableListOf<MainCategory>()
        for (cat in mainCats) {
            val mainCat = MainCategory(
                id = cat.id,
                name = cat.name,
                children = categoryRepository.findCategoriesByParentId(cat.id).toList()
            )
            out.add(mainCat)
        }
        return out
    }

    fun readCategory(id: Long): Category? {
        return categoryRepository.findByIdOrNull(id)
    }

    fun addCategory(Category: Category): Category {
        return categoryRepository.save(Category)
    }

    fun updateCategory(Category: Category): Category {
        return categoryRepository.save(Category)
    }

    fun deleteCategory(Category: Category) {
        categoryRepository.delete(Category)
    }

    fun deleteCategory(id: Long) {
        categoryRepository.deleteById(id)
    }
}