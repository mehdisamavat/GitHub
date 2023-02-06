package com.example.domain.usecase

import com.example.domain.NetworkResult
import com.example.domain.model.GitRepo
import com.example.domain.repository.IGitRepoRemoteRepository

class GitRepoDataUseCase(private val iGitRepoRemoteRepository: IGitRepoRemoteRepository) {
    suspend operator fun invoke(userName:String): NetworkResult<Unit> {
        return iGitRepoRemoteRepository.getGitRepo(userName)
    }
}