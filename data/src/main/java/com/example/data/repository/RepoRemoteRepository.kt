package com.example.data.repository

import com.example.data.local.dao.GitRepoDao
import com.example.data.mapper.GitMapper.toDomain
import com.example.data.mapper.GitMapper.toEntity
import com.example.data.remote.ApiService
import com.example.data.remote.handler.onError
import com.example.data.remote.handler.onException
import com.example.data.remote.handler.onSuccess
import com.example.domain.NetworkResult
import com.example.domain.model.GitRepo
import com.example.domain.repository.IRepoRemoteRepository

class RepoRemoteRepository(private val apiService: ApiService, private val gitRepoDao: GitRepoDao) : IRepoRemoteRepository {
    override suspend fun getGitRepo(userName: String): NetworkResult<List<GitRepo>> {
        var networkResult : NetworkResult<List<GitRepo>>?=null
        apiService.getGitRepo(userName).onSuccess { list->
            gitRepoDao.insertAll(list.map { it.toEntity() })
            networkResult= NetworkResult.Success(list.map { gitRepoItem->gitRepoItem.toDomain()!!.also { it.isBookmark=gitRepoDao.findById(it.id)?.isBookmark?:false }})
        }.onError { code, message ->
            networkResult= NetworkResult.Error(code,message)
        }.onException {
            networkResult=   NetworkResult.Exception(it)
        }
        return  networkResult!!
    }
}