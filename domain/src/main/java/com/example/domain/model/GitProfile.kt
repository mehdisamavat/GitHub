package com.example.domain.model

data class GitProfile(
    val userName:String,
    val name: String,
    val bio: String,
    val avatar_url:String,
    val location: String,
    val followers: Int,
    val following: Int,
)
