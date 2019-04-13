package com.paulmillerd.photogalleryapp.di

import com.paulmillerd.photogalleryapp.api.ConsumerKeyInterceptor
import com.paulmillerd.photogalleryapp.api.GALLERY_API_URL
import com.paulmillerd.photogalleryapp.api.GalleryService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class GalleryApiModule {

    @Provides
    @Singleton
    fun providesConsumerKeyInterceptor(): ConsumerKeyInterceptor =
        ConsumerKeyInterceptor()

    @Provides
    @Singleton
    fun providesOkHttpClient(consumerKeyInterceptor: ConsumerKeyInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(consumerKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(GALLERY_API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesGalleryService(retrofit: Retrofit): GalleryService =
        retrofit.create(GalleryService::class.java)

}