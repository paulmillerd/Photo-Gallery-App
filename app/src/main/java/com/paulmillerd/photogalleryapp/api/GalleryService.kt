package com.paulmillerd.photogalleryapp.api

import com.paulmillerd.photogalleryapp.api.responseModels.GalleryPageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryService {

    @GET("v1/photos")
    fun getPhotos(
        @Query("feature") feature: String,
        @Query("page") page: Int,
        @Query("image_size[]") imageSizes: List<Int>
    ): Call<GalleryPageResponse>

}