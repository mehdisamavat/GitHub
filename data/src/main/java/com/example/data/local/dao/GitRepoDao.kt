package com.example.data.local.dao

import androidx.room.*
import com.example.data.entity.GitRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GitRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitRepoEntity: GitRepoEntity): Long

    @Query(value = "DELETE FROM bookmarked_repo WHERE id=:id")
    fun deleteById(id: Int): Int


    @Query(value = "SELECT * FROM bookmarked_repo ")
    fun getAllRepo(): Flow<List<GitRepoEntity>>

    @Query(value = "SELECT * FROM bookmarked_repo WHERE id = :id ")
    fun findById(id: Int): GitRepoEntity?

}