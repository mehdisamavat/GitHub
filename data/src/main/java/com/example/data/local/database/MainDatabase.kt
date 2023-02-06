package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.entity.GitRepoEntity
import com.example.data.local.dao.GitRepoDao

@Database(entities = [GitRepoEntity::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun favoriteDao(): GitRepoDao
}

