package ru.allwdesign.firstapplication.data.di

import ru.allwdesign.firstapplication.data.repository.AppRepositoryImpl
import ru.allwdesign.firstapplication.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppRepository(
        appRepositoryImpl: AppRepositoryImpl
    ): AppRepository
}