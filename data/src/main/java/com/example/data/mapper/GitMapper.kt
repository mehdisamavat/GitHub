package com.example.data.mapper

import com.example.data.entity.RepoEntity
import com.example.data.remote.model.profile.Profile
import com.example.data.remote.model.repo.RepoItem
import com.example.domain.model.GitProfile
import com.example.domain.model.GitRepo

object GitMapper {
    fun RepoEntity?.toDomain(): GitRepo? {
        return this?.let {
            GitRepo(id,name,full_name,description?:"",open_issues,watchers,isBookmark)

        }
    }

    fun GitRepo?.toEntity(): RepoEntity? {
        return this?.let {
            RepoEntity(id,name,full_name,description?:"",open_issues,watchers,isBookmark)
        }
    }

    fun RepoItem?.toDomain(): GitRepo? {
        return this?.let {
            GitRepo(id,name,full_name,description?:"Does not have any description!",open_issues,watchers,isBookmark = false )
        }
    }


    fun RepoItem?.toEntity(): RepoEntity? {
        return this?.let {
            RepoEntity(id,name,full_name,description?:"",open_issues,watchers,isBookmark = false )
        }
    }


    fun Profile?.toDomain(): GitProfile? {
        return this?.let {
            GitProfile(login,name,bio,avatar_url,location,followers,following)
        }
    }




}