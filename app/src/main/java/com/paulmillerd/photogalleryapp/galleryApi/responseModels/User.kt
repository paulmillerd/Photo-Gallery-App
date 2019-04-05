package com.paulmillerd.photogalleryapp.galleryApi.responseModels

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class User(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("cover_url")
    val coverUrl: String? = null,

    @field:SerializedName("firstname")
    val firstname: String? = null,

    @field:SerializedName("store_on")
    val storeOn: Boolean? = null,

    @field:SerializedName("city")
    val city: String? = null,

    @field:SerializedName("usertype")
    val usertype: Int? = null,

    @field:SerializedName("lastname")
    val lastname: String? = null,

    @field:SerializedName("upgrade_status")
    val upgradeStatus: Int? = null,

    @field:SerializedName("userpic_https_url")
    val userpicHttpsUrl: String? = null,

    @field:SerializedName("affection")
    val affection: Int? = null,

    @field:SerializedName("fullname")
    val fullname: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("userpic_url")
    val userpicUrl: String? = null,

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("avatars")
    val avatars: Avatars? = null
)