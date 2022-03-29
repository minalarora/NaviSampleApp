package com.minal.navisampleapp.di.git

import androidx.lifecycle.ViewModel
import com.minal.navisampleapp.di.ViewModelKey
import com.minal.navisampleapp.ui.GitViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class GitViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GitViewModel::class)
    abstract fun bindGitViewModel(viewModel: GitViewModel): ViewModel

}