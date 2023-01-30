package com.morphylix.android.trainingschedule.di

import com.google.gson.Gson
import com.morphylix.android.trainingschedule.data.network.TrainingApi
import com.morphylix.android.trainingschedule.util.BASE_URL
import com.morphylix.android.trainingschedule.util.DATE_FORMAT
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
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson().newBuilder().setDateFormat(DATE_FORMAT).create()
    }

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideTrainingApi(retrofit: Retrofit): TrainingApi {
        return retrofit.create(TrainingApi::class.java)
    }

}