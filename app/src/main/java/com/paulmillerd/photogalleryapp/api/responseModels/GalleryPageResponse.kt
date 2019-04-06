package com.paulmillerd.photogalleryapp.api.responseModels

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class GalleryPageResponse(

    @field:SerializedName("feature")
    val feature: String? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("filters")
    val filters: Filters? = null,

    @field:SerializedName("total_items")
    val totalItems: Int? = null,

    @field:SerializedName("photos")
    val photos: List<PhotosItem?>? = null,

    @field:SerializedName("current_page")
    val currentPage: Int? = null
)