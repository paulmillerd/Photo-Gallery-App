package com.paulmillerd.photogalleryapp.repositories

import com.paulmillerd.photogalleryapp.models.Photo
import com.paulmillerd.photogalleryapp.models.PhotoRow

class PhotoRowOrganizer {

    private var photoRowWip = PhotoRow()

    fun organizePhotos(photos: List<Photo>, callback: PhotoRowOrganizerCallback, isLastPage: Boolean = false) {
        val result = mutableListOf<PhotoRow>()

        photos.forEach { photo ->
            if (photoRowWip.previewNewHeightWidthRatio(photo) >= PhotoRow.TARGET_RATIO) {
                photoRowWip.add(photo)
            } else {
                result.add(photoRowWip)
                photoRowWip = PhotoRow()
                photoRowWip.add(photo)
            }
        }

        if (isLastPage) {
            result.add(photoRowWip)
            photoRowWip = PhotoRow()
        }

        callback.onPhotosOrganized(result)
    }

}