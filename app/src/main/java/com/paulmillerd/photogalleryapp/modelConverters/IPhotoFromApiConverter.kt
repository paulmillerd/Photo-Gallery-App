package com.paulmillerd.photogalleryapp.modelConverters

import com.paulmillerd.photogalleryapp.api.responseModels.PhotosItem
import com.paulmillerd.photogalleryapp.models.Photo

interface IPhotoFromApiConverter {
    fun convertApiModelToPhoto(apiModel: PhotosItem?): Photo
}
