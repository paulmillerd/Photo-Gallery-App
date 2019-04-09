package com.paulmillerd.photogalleryapp.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo

interface IGalleryRepository {
    fun getFeature(feature: Feature, imageSizes: List<ImageSize>): LiveData<PagedList<Photo>>
    fun getErrors(): LiveData<Int?>
}