package com.paulmillerd.photogalleryapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo
import com.paulmillerd.photogalleryapp.repositories.IGalleryRepository

class GalleryViewModel : ViewModel() {

    private var galleryRepository: IGalleryRepository? = null
    private val refresh = MutableLiveData<Boolean>()
    val popularPhotos: LiveData<PagedList<Photo>> = Transformations.switchMap(refresh) {
        galleryRepository?.getFeature(Feature.POPULAR, listOf(ImageSize.SMALL, ImageSize.LARGE))
    }
    var errors: LiveData<Int?>? = null

    fun init(galleryRepository: IGalleryRepository) {
        this.galleryRepository = galleryRepository
        errors = galleryRepository.getErrors()
    }

    fun refreshPopularPhotos() {
        refresh.postValue(true)
    }

}