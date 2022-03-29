package com.minal.navisampleapp.data.remote


import com.minal.navisampleapp.data.model.Git
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitService {

    @GET("/repos/{owner}/{repo}/pulls")
    suspend fun fetchPullRequests(@Path("owner") owner: String,
                           @Path("repo") repository: String,
                           @Query("state") state: String): Response<List<Git>>

}