package com.example.domain.repository

import com.example.domain.NetworkResult

interface IGitRepoRemoteRepository {
    suspend fun getGitRepo(userName: String): NetworkResult<Unit>
}