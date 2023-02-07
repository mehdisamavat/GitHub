package com.example.domain.usecase

import com.example.domain.model.GitRepo
import com.example.domain.repository.IRepoLocalRepository
import kotlinx.coroutines.flow.Flow

class GetAllLocalRepoUseCase(private val iRepoLocalRepository: IRepoLocalRepository) {
    operator fun invoke(): Flow<List<GitRepo?>> {
        return iRepoLocalRepository.getAllLocalRepo()
    }
}