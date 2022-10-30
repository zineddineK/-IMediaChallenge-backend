package com.karima.imedia.conroller

import com.karima.imedia.data.ProductRepository
import com.karima.imedia.model.Product
import com.karima.imedia.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"], allowedHeaders = ["*"], methods = [
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.PUT,
    RequestMethod.DELETE,
])
@RestController
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("/products")
    fun getAll(): ResponseEntity<List<Product>> {
        val products = productService.readAllProducts()
        return ResponseEntity.ok(products)
    }


    @GetMapping("/products/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Product> {
        val product = productService.readProduct(id)
        if (product != null)
            return ResponseEntity.ok(product)
        else
            return ResponseEntity.notFound().build()
    }

    @PostMapping("/products")
    fun post(@RequestBody product: Product): ResponseEntity<Product> {
        val created = productService.addProduct(product)
        return ResponseEntity.ok(created)
    }

    @PutMapping("/products")
    fun put(@RequestBody product: Product): ResponseEntity<Product> {
        val updated = productService.updateProduct(product)
        return ResponseEntity.ok(updated)
    }

    @PutMapping("/products/{id}")
    fun put(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> {
        product.id = id
        val updated = productService.updateProduct(product)
        return ResponseEntity.ok(updated)
    }


    @DeleteMapping("/products")
    fun delete(@RequestBody product: Product): ResponseEntity<Product> {
        productService.deleteProduct(product)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/products/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Product> {
        productService.deleteProduct(id)
        return ResponseEntity.ok().build()
    }
}