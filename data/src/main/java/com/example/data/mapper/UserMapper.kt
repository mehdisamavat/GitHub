package com.example.data.mapper

import com.example.data.entity.GitRepoEntity
import com.example.domain.model.GitRepo

object UserMapper {
    fun GitRepoEntity?.toDomain(): GitRepo? {
        return this?.let {
            GitRepo(id = it.id, name = it.name, checked = it.checked)
        }
    }

    fun GitRepo?.toEntity(): GitRepoEntity? {
        return this?.let {
            GitRepoEntity(id = it.id, name = it.name, checked = it.checked)
        }
    }

}