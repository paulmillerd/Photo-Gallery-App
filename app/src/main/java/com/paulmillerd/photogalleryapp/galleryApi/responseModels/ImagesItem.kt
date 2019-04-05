package com.paulmillerd.photogalleryapp.galleryApi.responseModels

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ImagesItem(

    @field:SerializedName("https_url")
    val httpsUrl: String? = null,

    @field:SerializedName("size")
    val size: Int? = null,

    @field:SerializedName("format")
    val format: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)