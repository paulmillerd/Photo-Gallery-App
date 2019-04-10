package com.paulmillerd.photogalleryapp.di

import com.paulmillerd.photogalleryapp.DateUtils
import com.paulmillerd.photogalleryapp.IDateUtils
import com.paulmillerd.photogalleryapp.api.GalleryService
import com.paulmillerd.photogalleryapp.modelConverters.IPhotoFromApiConverter
import com.paulmillerd.photogalleryapp.modelConverters.PhotoFromApiConverter
import com.paulmillerd.photogalleryapp.repositories.GalleryRepository
import com.paulmillerd.photogalleryapp.repositories.IGalleryRepository
import dagger.Module
import dagger.Provides
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesSimpleDateFormat(): DateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sszzzzz", Locale.getDefault())

    @Provides
    @Singleton
    fun providesIDateUtils(dateFormat: DateFormat): IDateUtils =
        DateUtils(dateFormat)

    @Provides
    @Singleton
    fun providesIPhotoFromApiConverter(dateUtils: IDateUtils): IPhotoFromApiConverter =
        PhotoFromApiConverter(dateUtils)

    @Provides
    @Singleton
    fun providesIGalleryRepository(galleryService: GalleryService, photoFromApiConverter: IPhotoFromApiConverter):
            IGalleryRepository =
        GalleryRepository(galleryService, photoFromApiConverter)

}