package com.example.domain.usecase

import com.example.domain.NetworkResult
import com.example.domain.model.GitProfile
import com.example.domain.repository.IGitProfileRepository

class GitProfileUseCase(private val iGitProfileRepository: IGitProfileRepository) {
    suspend operator fun invoke(userName: String): NetworkResult<GitProfile> {
      return  iGitProfileRepository.getGitProfile(userName)
    }
}