package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.networkModule
import com.example.myapplication.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, viewModule))

        }
    }
}
