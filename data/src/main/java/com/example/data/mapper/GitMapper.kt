package com.example.data.mapper

import android.util.Log
import com.example.data.entity.GitRepoEntity
import com.example.data.remote.model.profile.Profile
import com.example.data.remote.model.repo.Repo
import com.example.data.remote.model.repo.RepoItem
import com.example.domain.model.GitProfile
import com.example.domain.model.GitRepo

object GitMapper {
    fun GitRepoEntity?.toDomain(): GitRepo? {
        return this?.let {
//            GitRepo(name,full_name,description,private,open_issues,watchers,fork)
//            GitRepo(name,"","",false,0,0,false, isBookMark = false)
            GitRepo(id,name,full_name,description?:"",open_issues,watchers,fork,isBookMark)

        }
    }

    fun GitRepo?.toEntity(): GitRepoEntity? {
        return this?.let {
//            GitRepoEntity(name=name, full_name = full_name, description = description, private = private, open_issues = open_issues, watchers = watchers, fork = fork)
            GitRepoEntity(id,name,full_name,description?:"",open_issues,watchers,fork,isBookMark)
        }
    }

    fun RepoItem?.toDomain(): GitRepo? {
        return this?.let {
            GitRepo(id,name,full_name,description?:"",open_issues,watchers,fork,isBookMark = false )
        }
    }


    fun Profile?.toDomain(): GitProfile? {
        return this?.let {
            GitProfile(login,name,bio,avatar_url,location,followers,following,public_repos,public_gists)
        }
    }




}