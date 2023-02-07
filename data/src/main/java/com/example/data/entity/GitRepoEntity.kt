package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked_repo")
data class GitRepoEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val full_name: String,
    val description: String,
    val open_issues: Int,
    val watchers: Int,
    val fork: Boolean,
    val isBookMark: Boolean,
)

