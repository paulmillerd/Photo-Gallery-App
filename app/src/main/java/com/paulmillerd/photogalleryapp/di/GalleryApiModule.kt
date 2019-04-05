package com.paulmillerd.photogalleryapp.di

import com.paulmillerd.photogalleryapp.GALLERY_API_URL
import com.paulmillerd.photogalleryapp.galleryApi.ConsumerKeyInterceptor
import com.paulmillerd.photogalleryapp.galleryApi.GalleryService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class GalleryApiModule {

    @Provides
    @Singleton
    fun providesOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(ConsumerKeyInterceptor())
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(GALLERY_API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesGalleryService(retrofit: Retrofit) =
        retrofit.create(GalleryService::class.java)

}