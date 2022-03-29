package com.minal.navisampleapp.ui


import androidx.lifecycle.ViewModel
import com.minal.navisampleapp.data.GitRepository
import javax.inject.Inject

class GitViewModel @Inject constructor(repository: GitRepository) : ViewModel() {

    val pullRequests = repository.pullRequests

}