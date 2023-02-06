package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.NetworkResult
import com.example.domain.repository.IGitRepoRemoteRepository

class GitRepoRemoteRepository(private val apiService: ApiService) : IGitRepoRemoteRepository {
    override suspend fun getGitRepo(userName: String): NetworkResult<Unit> {
       return apiService.getGitRepo(userName)
    }
}