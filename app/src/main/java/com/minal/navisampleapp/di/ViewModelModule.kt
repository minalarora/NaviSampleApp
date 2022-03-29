package com.minal.navisampleapp.di

import dagger.Binds
import dagger.Module
import androidx.lifecycle.ViewModelProvider

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}