package com.paulmillerd.photogalleryapp.di

import com.paulmillerd.photogalleryapp.api.GalleryService
import com.paulmillerd.photogalleryapp.repositories.GalleryRepository
import com.paulmillerd.photogalleryapp.repositories.IGalleryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesIGalleryRepository(galleryService: GalleryService): IGalleryRepository {
        return GalleryRepository(galleryService)
    }

}