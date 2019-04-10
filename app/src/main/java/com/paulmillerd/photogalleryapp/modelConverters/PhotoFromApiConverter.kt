package com.paulmillerd.photogalleryapp.modelConverters

import com.paulmillerd.photogalleryapp.IDateUtils
import com.paulmillerd.photogalleryapp.api.responseModels.PhotosItem
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo

class PhotoFromApiConverter(private val dateUtils: IDateUtils) : IPhotoFromApiConverter {
    override fun convertApiModelToPhoto(apiModel: PhotosItem?): Photo {
        val dateTaken = if (apiModel?.takenAt != null) dateUtils.parseIso8601Date(apiModel.takenAt) else null

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