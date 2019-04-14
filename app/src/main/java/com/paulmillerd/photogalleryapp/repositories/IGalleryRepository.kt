package com.paulmillerd.photogalleryapp.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.PhotoRow

interface IGalleryRepository {
    fun getFeature(feature: Feature, imageSizes: List<ImageSize>): LiveData<PagedList<PhotoRow>>
    fun getErrors(): LiveData<Int?>
}