package com.example.data.repository

import com.example.data.local.dao.GitRepoDao
import com.example.data.mapper.GitMapper.toDomain
import com.example.data.remote.ApiService
import com.example.data.remote.handler.onError
import com.example.data.remote.handler.onException
import com.example.data.remote.handler.onSuccess
import com.example.data.remote.model.repo.RepoItem
import com.example.domain.NetworkResult
import com.example.domain.model.GitProfile
import com.example.domain.model.GitRepo
import com.example.domain.repository.IGitRepoRemoteRepository

class GitRepoRemoteRepository(private val apiService: ApiService,private val gitRepoDao: GitRepoDao) : IGitRepoRemoteRepository {
    override suspend fun getGitRepo(userName: String): NetworkResult<List<GitRepo>> {
        var networkResult : NetworkResult<List<GitRepo>>?=null
        apiService.getGitRepo(userName).onSuccess { list->
            networkResult= NetworkResult.Success(list.map { gitRepoItem->gitRepoItem.toDomain()!!.also { it.isBookMark=gitRepoDao.findById(it.id)?.isBookMark?:false } })
        }.onError { code, message ->
            networkResult=    NetworkResult.Error(code,message)
        }.onException {
            networkResult=   NetworkResult.Exception(it)
        }
        return  networkResult!!
    }
}