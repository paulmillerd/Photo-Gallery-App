package com.paulmillerd.photogalleryapp.viewModels

import androidx.lifecycle.ViewModel
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.repositories.IGalleryRepository

class GalleryViewModel : ViewModel() {

    private lateinit var galleryRepository: IGalleryRepository

    fun init(galleryRepository: IGalleryRepository) {
        this.galleryRepository = galleryRepository
    }

    fun getPopular() =
        galleryRepository.getFeature(Feature.POPULAR, listOf(ImageSize.SMALL, ImageSize.LARGE))

}