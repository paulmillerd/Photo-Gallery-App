package com.paulmillerd.photogalleryapp

import android.app.Application
import android.content.Context
import com.paulmillerd.photogalleryapp.di.AppComponent
import com.paulmillerd.photogalleryapp.di.DaggerAppComponent
import com.paulmillerd.photogalleryapp.di.GalleryApiModule

class PhotoGalleryApp : Application() {

    companion object {
        fun getAppComponent(context: Context): AppComponent {
            return (context.applicationContext as PhotoGalleryApp).component
        }
    }

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .galleryApiModule(GalleryApiModule())
            .build()
    }

}