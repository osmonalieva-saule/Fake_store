package com.example.myapplication.data.data_source

import com.example.myapplication.data.model.ProductDto
import retrofit2.http.GET


interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>

}
