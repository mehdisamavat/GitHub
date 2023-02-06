package com.example.data.local.dao

import androidx.room.*
import com.example.data.entity.GitRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GitRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitRepoEntity: GitRepoEntity): Long

    @Query(value = "DELETE FROM GitRepoEntity WHERE id=:id")
    fun deleteById(id: Int): Int


    @Query(value = "SELECT * FROM GitRepoEntity ")
    fun getAllRepo(): Flow<List<GitRepoEntity>>

}