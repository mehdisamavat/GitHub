package com.example.domain.repository

import com.example.domain.NetworkResult
import com.example.domain.model.GitRepo

interface IGitRepoRemoteRepository {
    suspend fun getGitRepo(userName: String): NetworkResult<List<GitRepo>>
}