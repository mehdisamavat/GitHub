package com.example.data.remote

import com.example.domain.NetworkResult
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST("")
    suspend fun getGitProfile(@Body userName: String): NetworkResult<Unit>


    @POST("")
    suspend fun getGitRepo(@Body userName: String): NetworkResult<Unit>


}