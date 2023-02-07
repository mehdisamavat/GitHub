package com.example.domain.usecase

import com.example.domain.NetworkResult
import com.example.domain.model.GitProfile
import com.example.domain.repository.IProfileRepository

class GetRemoteProfileUseCase(private val iProfileRepository: IProfileRepository) {
    suspend operator fun invoke(userName: String): NetworkResult<GitProfile> {
      return  iProfileRepository.getGitProfile(userName)
    }
}