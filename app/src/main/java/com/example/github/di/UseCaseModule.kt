package com.example.github.di

import com.example.domain.repository.IFavLocalRepository
import com.example.domain.repository.IGitProfileRepository
import com.example.domain.repository.IGitRepoRemoteRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {


    @Provides
    @ViewModelScoped
    fun provideGetFavRepoUseCase(iFavLocalRepository: IFavLocalRepository) =
        GetFavRepoUseCase(iFavLocalRepository)

    @Provides
    @ViewModelScoped
    fun provideDeleteFavRepoUseCase(iFavLocalRepository: IFavLocalRepository) =
        DeleteFavRepoUseCase(iFavLocalRepository)


    @Provides
    @ViewModelScoped
    fun provideAddFavRepoUseCase(iFavLocalRepository: IFavLocalRepository) =
        AddFavRepoUseCase(iFavLocalRepository)


    @Provides
    @Singleton
    fun provideGitProfileUseCase(iGitProfileRepository: IGitProfileRepository) =
        GitProfileUseCase(iGitProfileRepository)

    @Provides
    @Singleton
    fun provideGitRepoDataUseCase(iGitRepoRemoteRepository: IGitRepoRemoteRepository) =
        GitRepoDataUseCase(iGitRepoRemoteRepository)

}