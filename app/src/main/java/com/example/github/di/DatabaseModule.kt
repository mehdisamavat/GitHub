package com.example.github.di

import android.app.Application
import androidx.room.Room
import com.example.data.local.database.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideMainDatabase(application: Application) =
        Room.databaseBuilder(application, MainDatabase::class.java, "main").allowMainThreadQueries().build()

    @Provides
    fun provideGitDao(mainDatabase: MainDatabase) = mainDatabase.favoriteDao()


}