package com.example.github.di

import com.example.data.local.dao.GitRepoDao
import com.example.data.remote.ApiService
import com.example.data.repository.FavLocalRepository
import com.example.data.repository.GitProfileRemoteRepository
import com.example.data.repository.GitRepoRemoteRepository
import com.example.domain.repository.IFavLocalRepository
import com.example.domain.repository.IGitProfileRepository
import com.example.domain.repository.IGitRepoRemoteRepository
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
    fun provideFavLocalRepository(gitRepoDao: GitRepoDao): IFavLocalRepository = FavLocalRepository(gitRepoDao)

    @Provides
    @Singleton
    fun provideGitRepoRemoteRepository(apiService: ApiService): IGitRepoRemoteRepository = GitRepoRemoteRepository(apiService)

    @Provides
    @Singleton
    fun provideSchedulerRepository(apiService: ApiService): IGitProfileRepository = GitProfileRemoteRepository(apiService)


}