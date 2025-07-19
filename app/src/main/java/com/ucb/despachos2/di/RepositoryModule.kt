package com.ucb.despachos2.di

import com.ucb.despachos2.data.remote.AuthApi
import com.ucb.despachos2.data.repository.AuthRepositoryImpl
import com.ucb.despachos2.domain.repository.AuthRepository
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
    fun provideAuthRepository(api : AuthApi): AuthRepository=
        AuthRepositoryImpl(api)
}