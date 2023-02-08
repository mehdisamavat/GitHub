package com.example.github.di

import com.example.data.local.dao.GitRepoDao
import com.example.data.remote.ApiService
import com.example.data.repository.ProfileRemoteRepository
import com.example.data.repository.RepoLocalRepository
import com.example.data.repository.RepoRemoteRepository
import com.example.domain.repository.IProfileRepository
import com.example.domain.repository.IRepoLocalRepository
import com.example.domain.repository.IRepoRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFavLocalRepository(gitRepoDao: GitRepoDao): IRepoLocalRepository = RepoLocalRepository(gitRepoDao)

    @Provides
    @Singleton
    fun provideGitRepoRemoteRepository(apiService: ApiService,gitRepoDao: GitRepoDao): IRepoRemoteRepository = RepoRemoteRepository(apiService,gitRepoDao)

    @Provides
    @Singleton
    fun provideSchedulerRepository(apiService: ApiService): IProfileRepository = ProfileRemoteRepository(apiService)


}