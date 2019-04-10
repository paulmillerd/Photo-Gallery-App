package com.paulmillerd.photogalleryapp

import java.util.*

interface IDateUtils {
    fun parseIso8601Date(isoString: String): Date?
}
