package com.minal.navisampleapp.di.git


import com.minal.navisampleapp.base.AppDatabase
import com.minal.navisampleapp.data.remote.GitRemoteDataSource
import com.minal.navisampleapp.data.remote.GitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Suppress("unused")
@Module
class GitDataModule {

    @Singleton
    @Provides
    fun provideGitService(retrofit: Retrofit): GitService = retrofit.create(GitService::class.java)

    @Singleton
    @Provides
    fun provideGitRemoteDataSource(service: GitService)
            = GitRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideGitDao(db: AppDatabase) = db.gitDao()
}