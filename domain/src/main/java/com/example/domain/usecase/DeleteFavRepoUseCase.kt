package com.example.domain.usecase

import com.example.domain.repository.IFavLocalRepository

class DeleteFavRepoUseCase(private val iFavLocalRepository: IFavLocalRepository) {
    operator fun invoke(id: Int): Int {
        return iFavLocalRepository.deleteFavLocalRepo(id)
    }
}