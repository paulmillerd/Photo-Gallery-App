package com.paulmillerd.photogalleryapp.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Singleton

@Singleton
class ConsumerKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val ogRequest = chain.request()
        val ogUrl = ogRequest.url()

        val url = ogUrl.newBuilder()
            .addQueryParameter(GALLERY_CONSUMER_KEY_QUERY_NAME, GALLERY_CONSUMER_KEY)
            .build()

        val request = ogRequest.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}