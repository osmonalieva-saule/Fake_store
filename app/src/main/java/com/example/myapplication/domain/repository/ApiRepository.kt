package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Product

interface ApiRepository {
    suspend fun getProducts(): List<Product>

}