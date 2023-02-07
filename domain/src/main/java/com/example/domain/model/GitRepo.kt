package com.example.domain.model

data class GitRepo(
    val id:Int,
    val name: String,
    val full_name: String,
    val description: String,
    val open_issues: Int,
    val watchers: Int,
    val fork: Boolean,
    var isBookmark:Boolean
    )
