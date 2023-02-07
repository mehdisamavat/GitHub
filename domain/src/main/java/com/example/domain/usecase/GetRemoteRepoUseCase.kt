package com.example.domain.usecase

import com.example.domain.NetworkResult
import com.example.domain.model.GitRepo
import com.example.domain.repository.IRepoRemoteRepository

class GetRemoteRepoUseCase(private val iRepoRemoteRepository: IRepoRemoteRepository) {
    suspend operator fun invoke(userName:String): NetworkResult<List<GitRepo>> {
        return iRepoRemoteRepository.getGitRepo(userName)
    }
}