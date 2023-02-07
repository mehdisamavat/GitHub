package com.example.data.repository

import com.example.data.local.dao.GitRepoDao
import com.example.data.mapper.GitMapper.toDomain
import com.example.domain.model.GitRepo
import com.example.domain.repository.IRepoLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RepoLocalRepository(private val gitRepoDao: GitRepoDao) : IRepoLocalRepository {
    override fun getAllLocalRepo(): Flow<List<GitRepo?>> {
        return gitRepoDao.getAllRepo().map { list -> list.map { it.toDomain() }  }
    }

    override fun updateBookmark(id: Int, isBookmark: Boolean) {
        return gitRepoDao.updateBookmark(id,isBookmark)
    }
}