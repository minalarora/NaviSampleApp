package com.minal.navisampleapp.data

import com.minal.navisampleapp.base.resultLiveData
import com.minal.navisampleapp.data.local.GitDao
import com.minal.navisampleapp.data.remote.GitRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitRepository @Inject constructor(private val remoteDataSource: GitRemoteDataSource,
                        private val localDataSource: GitDao) {

    val pullRequests = resultLiveData(
        databaseQuery = { localDataSource.getPullRequest() },
        networkCall = {  remoteDataSource.fetchPullRequests() },
        saveCallResult = { localDataSource.insertAll(it) })

}