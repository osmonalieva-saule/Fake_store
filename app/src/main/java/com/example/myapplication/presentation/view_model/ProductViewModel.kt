package com.example.myapplication.presentation.view_model

import com.example.myapplication.data.model.ProductDto
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.mapper.toData
import com.example.myapplication.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val useCase: GetProductsUseCase,
    private val main : CoroutineDispatcher
) : ViewModel() {

    private val _products = MutableStateFlow<List<ProductDto>>(emptyList())
    val products: StateFlow<List<ProductDto>> = _products.asStateFlow()

    init {
        viewModelScope.launch(main) {
            val productList = useCase.execute()
            _products.value = productList.map { it.toData() }
        }
    }
}