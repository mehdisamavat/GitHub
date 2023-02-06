package com.example.domain.repository

import com.example.domain.model.GitRepo
import kotlinx.coroutines.flow.Flow

interface IFavLocalRepository {
    fun getAllFavLocalRepo(): Flow<List<GitRepo?>>

    fun deleteFavLocalRepo(id: Int): Int

    fun addFavLocalRepo(gitRepo: GitRepo): Long
}
