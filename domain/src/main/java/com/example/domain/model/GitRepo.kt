package com.example.domain.model

data class GitRepo(
    val name: String,
    val full_name: String,
    val description: String,
    val private: Boolean,
    val open_issues: Int,
    val watchers: Int,
    val fork: Boolean
    )
