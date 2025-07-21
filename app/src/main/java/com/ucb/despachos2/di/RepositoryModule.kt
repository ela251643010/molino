package com.ucb.despachos2.di

import android.content.Context
import com.ucb.despachos2.data.local.AuthPreferences
import com.ucb.despachos2.data.remote.AuthApi
import com.ucb.despachos2.data.repository.AuthRepositoryImpl
import com.ucb.despachos2.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthPreferences(
        @ApplicationContext context: Context
    ):AuthPreferences{
        return AuthPreferences(context)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        api : AuthApi,
        authPreferences: AuthPreferences
    ): AuthRepository=
        AuthRepositoryImpl(api,authPreferences)
}