package com.example.domain.usecase

import com.example.domain.model.GitRepo
import com.example.domain.repository.IFavLocalRepository
import kotlinx.coroutines.flow.Flow

class GetFavRepoUseCase(private val iFavLocalRepository: IFavLocalRepository) {
    operator fun invoke(): Flow<List<GitRepo?>> {
        return iFavLocalRepository.getAllFavLocalRepo()
    }
}