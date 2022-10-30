package com.karima.imedia.service

import com.karima.imedia.conroller.ProductController
import com.karima.imedia.data.ProductRepository
import com.karima.imedia.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun readAllProducts(): List<Product> {
        return productRepository.findAll().toList()
    }

    fun readProduct(id: Long): Product? {
        return productRepository.findByIdOrNull(id)
    }

    fun addProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun updateProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun deleteProduct(product: Product) {
        productRepository.delete(product)
    }


    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }
}