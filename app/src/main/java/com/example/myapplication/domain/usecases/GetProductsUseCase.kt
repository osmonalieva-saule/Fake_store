package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.repository.ApiRepository

class GetProductsUseCase(private val repository: ApiRepository) {
    suspend fun execute(): List<Product> {
        return repository.getProducts()
    }
}