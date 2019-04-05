package com.paulmillerd.photogalleryapp.galleryApi.responseModels

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Avatars(

    @field:SerializedName("small")
    val small: Small? = null,

    @field:SerializedName("default")
    val jsonMemberDefault: JsonMemberDefault? = null,

    @field:SerializedName("large")
    val large: Large? = null,

    @field:SerializedName("tiny")
    val tiny: Tiny? = null
)