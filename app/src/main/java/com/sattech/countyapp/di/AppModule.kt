package com.sattech.countyapp.di

import com.sattech.countyapp.data.network.ApiInterface
import com.sattech.countyapp.data.repository.PostRepositoryImpl
import com.sattech.countyapp.domain.repository.PostRepository
import com.sattech.countyapp.domain.use_case.GetPostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    private val BASE_URL = "https://gorest.co.in/public/"

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create<ApiInterface>(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(apiInterface: ApiInterface): PostRepository {
        return PostRepositoryImpl(apiInterface)
    }

    @Provides
    fun provideGetPostUseCase(postRepository: PostRepository): GetPostUseCase {
        return GetPostUseCase(postRepository)
    }
}