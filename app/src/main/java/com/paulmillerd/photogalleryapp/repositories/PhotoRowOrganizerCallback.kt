package com.paulmillerd.photogalleryapp.repositories

import com.paulmillerd.photogalleryapp.models.PhotoRow

interface PhotoRowOrganizerCallback {
    fun onPhotosOrganized(photoRows: List<PhotoRow>)
}