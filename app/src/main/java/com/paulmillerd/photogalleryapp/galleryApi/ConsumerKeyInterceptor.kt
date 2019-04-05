package com.paulmillerd.photogalleryapp.galleryApi

import com.paulmillerd.photogalleryapp.GALLERY_CONSUMER_KEY
import okhttp3.Interceptor
import okhttp3.Response

class ConsumerKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ogRequest = chain.request()
        val ogUrl = ogRequest.url()

        val url = ogUrl.newBuilder()
            .addQueryParameter("consumer_key", GALLERY_CONSUMER_KEY)
            .build()

        val request = ogRequest.newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}