package com.ucb.despachos2.di

import com.ucb.despachos2.data.remote.AuthApi
import com.ucb.despachos2.data.remote.EntregaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   /* @Provides
    fun provideBaseUrl()="localhost:8080"*/
    @Provides
    fun provideBaseUrl() = "http://10.0.2.2:8080"


    @Provides
    @Singleton
    fun provideOkHttpCliente(): OkHttpClient=
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
               setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,BASE_URL: String):Retrofit=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi=
        retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideEntregaApi(retrofit: Retrofit):EntregaApi =
        retrofit.create(EntregaApi::class.java)
}