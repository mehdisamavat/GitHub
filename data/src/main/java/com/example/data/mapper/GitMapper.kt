package com.example.data.mapper

import com.example.data.entity.GitRepoEntity
import com.example.data.remote.model.profile.Profile
import com.example.domain.model.GitProfile
import com.example.domain.model.GitRepo

object GitMapper {
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

    fun Profile?.toDomain(): GitProfile? {
        return this?.let {
            GitProfile(login,name,bio,avatar_url,location,followers,following,public_repos,public_gists)
        }
    }




}