package com.example.data.repository

import com.example.data.mapper.GitMapper.toDomain
import com.example.data.remote.ApiService
import com.example.data.remote.handler.onError
import com.example.data.remote.handler.onException
import com.example.data.remote.handler.onSuccess
import com.example.domain.NetworkResult
import com.example.domain.model.GitProfile
import com.example.domain.repository.IProfileRepository

class ProfileRemoteRepository(private val apiService: ApiService) : IProfileRepository {
    override suspend fun getGitProfile(userName: String): NetworkResult<GitProfile> {
        var networkResult : NetworkResult<GitProfile>?=null
         apiService.getGitProfile(userName).onSuccess {
             networkResult= NetworkResult.Success(it.toDomain()!!)
         }.onError { code, message ->
             networkResult=    NetworkResult.Error(code,message)
         }.onException {
             networkResult=   NetworkResult.Exception(it)
         }
        return  networkResult!!
    }
}