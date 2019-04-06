package com.paulmillerd.photogalleryapp

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        fun formatDate(date: Date): String {
            return SimpleDateFormat("MMMM dd, YYYY").format(date)
        }

        fun parseIso8601Date(isoString: String): Date? {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sszzzzz")
            return try {
                format.parse(isoString)
            } catch (e: ParseException) {
                e.printStackTrace()
                null
            }

        }
    }
}