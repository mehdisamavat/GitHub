package com.example.domain.repository

import com.example.domain.NetworkResult

interface IGitProfileRepository {
    suspend fun getGitProfile(userName: String): NetworkResult<Unit>
}