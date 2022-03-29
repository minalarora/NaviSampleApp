package com.minal.navisampleapp.di.git

import com.minal.navisampleapp.ui.GitActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module(includes = [GitDataModule::class, GitViewModelModule::class])
abstract class GitActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeGitActivity(): GitActivity

}