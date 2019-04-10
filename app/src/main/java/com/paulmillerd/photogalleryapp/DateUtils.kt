package com.paulmillerd.photogalleryapp

import java.text.DateFormat
import java.text.ParseException
import java.util.*

class DateUtils(private val dateFormat: DateFormat) : IDateUtils {

    override fun parseIso8601Date(isoString: String): Date? {
        return try {
            dateFormat.parse(isoString)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }

}