package com.example.domain.repository

import com.example.domain.NetworkResult
import com.example.domain.model.GitProfile

interface IGitProfileRepository {
    suspend fun getGitProfile(userName: String): NetworkResult<GitProfile>
}