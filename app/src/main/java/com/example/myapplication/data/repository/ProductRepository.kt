package com.example.myapplication.data.repository

import com.example.myapplication.data.data_source.ApiService
import com.example.myapplication.data.mapper.toDomain
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.repository.ApiRepository

class ProductRepository(
   private val api: ApiService,

):ApiRepository {

   override suspend fun getProducts(): List<Product> {
   val response = api.getProducts()
   return response.map { it.toDomain() }
   }

}