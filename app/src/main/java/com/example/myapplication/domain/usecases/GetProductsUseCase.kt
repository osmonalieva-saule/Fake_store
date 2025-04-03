package com.example.myapplication.domain.usecases

import com.example.myapplication.data.model.ProductDto
import com.example.myapplication.data.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {
    suspend fun execute(): List<ProductDto> {
        return repository.getProducts()
    }
}