package com.karima.imedia.conroller

import com.karima.imedia.model.Category
import com.karima.imedia.model.MainCategory
import com.karima.imedia.service.CategoryService
import org.springframework.data.repository.CrudRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RestController
class CategoryController(
    private val categoryService: CategoryService
) {


    @GetMapping("/categories")
    fun getAll(): ResponseEntity<List<Category>> {
        val categories = categoryService.readAllCategories()
        return ResponseEntity.ok(categories)
    }

    @GetMapping("/categories/main")
    fun getMain(): ResponseEntity<List<MainCategory>> {
        val categories = categoryService.readMainCategories()
        return ResponseEntity.ok(categories)
    }


    @GetMapping("/categories/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Category> {
        val category = categoryService.readCategory(id)
        if (category != null)
            return ResponseEntity.ok(category)
        else
            return ResponseEntity.notFound().build()
    }

    @PostMapping("/categories")
    fun post(@RequestBody category: Category): ResponseEntity<Category> {
        val created = categoryService.addCategory(category)
        return ResponseEntity.ok(created)
    }

    @PutMapping("/categories")
    fun put(@RequestBody category: Category): ResponseEntity<Category> {
        val updated = categoryService.updateCategory(category)
        return ResponseEntity.ok(updated)
    }

    @PutMapping("/categories/{id}")
    fun put(@PathVariable id: Long, @RequestBody category: Category): ResponseEntity<Category> {
        category.id = id
        val updated = categoryService.updateCategory(category)
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/categories")
    fun delete(@RequestBody category: Category): ResponseEntity<Category> {
        categoryService.deleteCategory(category)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/categories/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Category> {
        categoryService.deleteCategory(id)
        return ResponseEntity.ok().build()
    }
}