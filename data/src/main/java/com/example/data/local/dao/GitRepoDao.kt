package com.example.data.local.dao

import androidx.room.*
import com.example.data.entity.RepoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface GitRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repoEntity: RepoEntity): Long

    @Query(value = "SELECT * FROM repo ")
    fun getAllRepo(): Flow<List<RepoEntity>>

    @Query(value = "SELECT * FROM repo WHERE id = :id ")
    fun findById(id: Int): RepoEntity?

    @Query("UPDATE repo SET isBookmark = :isBookmark WHERE id =:id")
    fun updateBookmark(id: Int, isBookmark:Boolean)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(order: List<RepoEntity?>?)

}