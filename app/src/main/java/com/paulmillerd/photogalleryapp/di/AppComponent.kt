package com.paulmillerd.photogalleryapp.di

import com.paulmillerd.photogalleryapp.fragments.GalleryFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GalleryApiModule::class])
interface AppComponent {
    fun inject(galleryFragment: GalleryFragment)
}