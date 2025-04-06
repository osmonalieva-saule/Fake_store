package com.example.myapplication.di


import com.example.myapplication.domain.usecases.GetProductsUseCase
import com.example.myapplication.presentation.view_model.ProductViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        ProductViewModel(
            useCase = get(),
            main = get(named("MAIN"))
        )
    }
    single { GetProductsUseCase(repository = get()) }
    single <CoroutineDispatcher> (named("IO")){ Dispatchers.IO}
    single <CoroutineDispatcher> (named("MAIN")){ Dispatchers.Main}
}

