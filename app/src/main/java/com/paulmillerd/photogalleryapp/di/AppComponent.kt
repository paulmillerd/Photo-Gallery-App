package com.paulmillerd.photogalleryapp.di

import com.paulmillerd.photogalleryapp.gallery.GalleryFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GalleryApiModule::class, AppModule::class])
interface AppComponent {
    fun inject(galleryFragment: GalleryFragment)
}