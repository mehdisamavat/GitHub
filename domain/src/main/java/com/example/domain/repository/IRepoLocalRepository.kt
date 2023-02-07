package com.example.domain.repository

import com.example.domain.model.GitRepo
import kotlinx.coroutines.flow.Flow

interface IRepoLocalRepository {
    fun getAllLocalRepo(): Flow<List<GitRepo?>>

    fun updateBookmark(id:Int, isBookmark:Boolean)

}
