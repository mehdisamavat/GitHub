package com.example.domain.usecase

import com.example.domain.model.GitRepo
import com.example.domain.repository.IFavLocalRepository

class AddFavRepoUseCase(private val iFavLocalRepository: IFavLocalRepository) {
    operator fun invoke(gitRepo: GitRepo): Long {
        return iFavLocalRepository.addFavLocalRepo(gitRepo)
    }
}