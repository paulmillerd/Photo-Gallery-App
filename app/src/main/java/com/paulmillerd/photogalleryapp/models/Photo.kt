package com.paulmillerd.photogalleryapp.models

import java.io.Serializable
import java.util.*

data class Photo(
    val id: Long?,
    val name: String?,
    val description: String?,
    val rating: Double?,
    val bigUrl: String?,
    val smallUrl: String?,
    val username: String?,
    val heightWidthRatio: Double?,
    val dateTaken: Date?
) : Serializable