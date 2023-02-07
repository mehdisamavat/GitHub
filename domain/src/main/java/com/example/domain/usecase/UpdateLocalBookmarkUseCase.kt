package com.example.domain.usecase

import com.example.domain.repository.IRepoLocalRepository

class UpdateLocalBookmarkUseCase(private val iRepoLocalRepository: IRepoLocalRepository) {
    operator fun invoke(id:Int,isBookmark:Boolean) {
        return iRepoLocalRepository.updateBookmark(id,isBookmark)
    }
}