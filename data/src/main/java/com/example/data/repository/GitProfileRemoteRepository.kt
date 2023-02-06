package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.NetworkResult
import com.example.domain.repository.IGitProfileRepository

class GitProfileRemoteRepository(private val apiService: ApiService) : IGitProfileRepository {
    override suspend fun getGitProfile(userName: String): NetworkResult<Unit> {
        return apiService.getGitProfile(userName)
    }
}