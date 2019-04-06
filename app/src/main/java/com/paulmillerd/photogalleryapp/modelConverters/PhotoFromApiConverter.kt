package com.paulmillerd.photogalleryapp.modelConverters

import com.paulmillerd.photogalleryapp.DateUtils.Companion.parseIso8601Date
import com.paulmillerd.photogalleryapp.api.responseModels.PhotosItem
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo

class PhotoFromApiConverter {
    companion object {
        fun convertApiModelToPhoto(apiModel: PhotosItem?): Photo {
            val dateTaken = if (apiModel?.takenAt != null) parseIso8601Date(apiModel.takenAt) else null

            return Photo(
                id = apiModel?.id,
                name = apiModel?.name,
                description = apiModel?.description,
                rating = apiModel?.rating,
                username = apiModel?.user?.username,
                dateTaken = dateTaken,
                bigUrl = apiModel?.images?.find { it?.size == ImageSize.LARGE.value }?.httpsUrl,
                smallUrl = apiModel?.images?.find { it?.size == ImageSize.SMALL.value }?.httpsUrl,
                heightWidthRatio = (apiModel?.height?.toDouble() ?: 1.0) / (apiModel?.width?.toDouble() ?: 1.0)
            )
        }


    }
}