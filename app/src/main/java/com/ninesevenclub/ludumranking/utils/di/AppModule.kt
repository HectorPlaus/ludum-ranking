package com.ninesevenclub.ludumranking.utils.di

import com.ninesevenclub.ludumranking.data.remote.LRService
import com.ninesevenclub.ludumranking.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   /* @Provides
    @Singleton
    fun provideRetrofit(): LRService {
        return LRService.create()
    }*/

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLRAPI(retrofit: Retrofit): LRService {
        return retrofit.create(LRService::class.java)
    }

}