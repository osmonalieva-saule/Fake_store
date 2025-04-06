package com.example.myapplication.data.mapper

import com.example.myapplication.data.model.ProductDto
import com.example.myapplication.domain.model.Product

fun Product.toData():ProductDto{
    return ProductDto(
        id, title, price, image
    )
}
fun ProductDto.toDomain(): Product{
    return Product(
        id, title, price, image
    )
}