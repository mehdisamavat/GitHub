package com.example.github.di

import com.example.domain.repository.IRepoLocalRepository
import com.example.domain.repository.IProfileRepository
import com.example.domain.repository.IRepoRemoteRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {


    @Provides
    @ViewModelScoped
    fun provideGetFavRepoUseCase(iRepoLocalRepository: IRepoLocalRepository) =
        GetAllLocalRepoUseCase(iRepoLocalRepository)

    @Provides
    @ViewModelScoped
    fun provideAddFavRepoUseCase(iRepoLocalRepository: IRepoLocalRepository) =
        UpdateLocalBookmarkUseCase(iRepoLocalRepository)


    @Provides
    @ViewModelScoped
    fun provideGitProfileUseCase(iProfileRepository: IProfileRepository) = GetRemoteProfileUseCase(iProfileRepository)

    @Provides
    @ViewModelScoped
    fun provideGitRepoDataUseCase(iRepoRemoteRepository: IRepoRemoteRepository) =
        GetRemoteRepoUseCase(iRepoRemoteRepository)

}