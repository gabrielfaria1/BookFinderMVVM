package com.example.bookfinder.di

import android.app.Application
import android.content.Context
import com.example.bookfinder.network.ApiService
import com.example.bookfinder.repository.BooksRepository
import com.example.bookfinder.repository.BooksRepositoryImpl
import com.example.bookfinder.domain.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideBooksRepository(
        apiService: ApiService
    ): BooksRepository {
        return BooksRepositoryImpl(
            apiService
        )
    }

}