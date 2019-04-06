package com.paulmillerd.photogalleryapp.api.responseModels

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Filters(

    @field:SerializedName("exclude")
    val exclude: List<Int?>? = null,

    @field:SerializedName("category")
    val category: Boolean? = null
)