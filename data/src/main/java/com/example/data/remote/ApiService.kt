package com.example.data.remote

import com.example.data.remote.model.profile.Profile
import com.example.domain.NetworkResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {

    @GET("/users/{userName}")
    suspend fun getGitProfile(@Path("userName") userName: String): NetworkResult<Profile>


    @POST("/users/{userName}/repos")
    suspend fun getGitRepo(@Path("userName") userName: String): NetworkResult<Unit>


}