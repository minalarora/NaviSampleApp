package com.minal.navisampleapp.data.remote

import com.minal.navisampleapp.base.BaseDataSource
import javax.inject.Inject

class GitRemoteDataSource @Inject constructor(private val service: GitService) : BaseDataSource() {

    suspend fun fetchPullRequests() = getResult { service.fetchPullRequests("bumptech",
                                                    "glide" , "closed") }

}