package com.example.myapplication.data.repository

import com.example.myapplication.data.data_source.ApiService
import com.example.myapplication.data.model.ProductDto

class ProductRepository(private val api: ApiService) {
    suspend fun getProducts(): List<ProductDto> = api.getProducts()
}