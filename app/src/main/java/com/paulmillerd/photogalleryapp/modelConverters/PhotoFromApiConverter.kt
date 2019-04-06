package com.paulmillerd.photogalleryapp.modelConverters

import com.paulmillerd.photogalleryapp.galleryApi.responseModels.PhotosItem
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo
import java.text.DateFormat
import java.util.*

class PhotoFromApiConverter {
    companion object {
        fun convertApiModelToPhoto(apiModel: PhotosItem?): Photo {
            var dateTaken: Date? = null
            try {
                dateTaken = DateFormat.getDateInstance().parse(apiModel?.takenAt)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return Photo(
                id = apiModel?.id,
                name = apiModel?.name,
                description = apiModel?.description,
                rating = apiModel?.rating,
                username = apiModel?.user?.username,
                dateTaken = dateTaken,
                bigUrl = apiModel?.images?.find { it?.size == ImageSize.LARGE.value }?.httpsUrl,
                smallUrl = apiModel?.images?.find { it?.size == ImageSize.SMALL.value }?.httpsUrl
            )
        }
    }
}