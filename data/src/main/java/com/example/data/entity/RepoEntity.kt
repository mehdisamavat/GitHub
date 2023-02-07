package com.example.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo")
data class RepoEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val full_name: String,
    @ColumnInfo(defaultValue = "Does not have any description!")
    val description: String,
    val open_issues: Int,
    val watchers: Int,
    val fork: Boolean,
    @ColumnInfo(defaultValue = "false")
    val isBookmark: Boolean
)

