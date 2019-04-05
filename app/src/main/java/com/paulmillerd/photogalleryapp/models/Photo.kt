package com.paulmillerd.photogalleryapp.models

import java.util.*

data class Photo(
    val name: String,
    val description: String,
    val rating: Float,
    val bigUrl: String,
    val smallUrl: String,
    val username: String,
    val dateTaken: Date
)