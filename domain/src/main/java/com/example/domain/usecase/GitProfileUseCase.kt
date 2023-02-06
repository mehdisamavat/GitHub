package com.example.domain.usecase

import com.example.domain.repository.IGitProfileRepository

class GitProfileUseCase(private val iGitProfileRepository: IGitProfileRepository) {
    suspend operator fun invoke(userName: String) {
        iGitProfileRepository.getGitProfile(userName)
    }
}