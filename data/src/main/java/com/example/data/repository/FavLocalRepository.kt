package com.example.data.repository

import com.example.data.local.dao.GitRepoDao
import com.example.data.mapper.GitMapper.toDomain
import com.example.data.mapper.GitMapper.toEntity
import com.example.domain.model.GitRepo
import com.example.domain.repository.IFavLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavLocalRepository(private val gitRepoDao: GitRepoDao) : IFavLocalRepository {
    override fun getAllFavLocalRepo(): Flow<List<GitRepo?>> {
        return gitRepoDao.getAllRepo().map { list -> list.map { it.toDomain() } }
    }

    override fun deleteFavLocalRepo(id: Int): Int {
        return gitRepoDao.deleteById(id)
    }

    override fun addFavLocalRepo(gitRepo: GitRepo): Long {
        return gitRepoDao.insert(gitRepo.toEntity()!!)
    }

}