package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GitRepoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    var checked: Boolean
)