package com.paulmillerd.photogalleryapp.galleryApi.responseModels

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class PhotosItem(

    @field:SerializedName("exclude_gads")
    val excludeGads: Boolean? = null,

    @field:SerializedName("license_requests_enabled")
    val licenseRequestsEnabled: Boolean? = null,

    @field:SerializedName("iso")
    val iso: String? = null,

    @field:SerializedName("rating")
    val rating: Double? = null,

    @field:SerializedName("voted")
    val voted: Boolean? = null,

    @field:SerializedName("liked")
    val liked: Boolean? = null,

    @field:SerializedName("request_to_buy_enabled")
    val requestToBuyEnabled: Boolean? = null,

    @field:SerializedName("disliked")
    val disliked: Boolean? = null,

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("image_format")
    val imageFormat: String? = null,

    @field:SerializedName("is_free_photo")
    val isFreePhoto: Boolean? = null,

    @field:SerializedName("height")
    val height: Int? = null,

    @field:SerializedName("longitude")
    val longitude: Double? = null,

    @field:SerializedName("converted_bits")
    val convertedBits: Int? = null,

    @field:SerializedName("images")
    val images: List<ImagesItem?>? = null,

    @field:SerializedName("watermark")
    val watermark: Boolean? = null,

    @field:SerializedName("image_url")
    val imageUrl: List<String?>? = null,

    @field:SerializedName("profile")
    val profile: Boolean? = null,

    @field:SerializedName("editors_choice")
    val editorsChoice: Boolean? = null,

    @field:SerializedName("shutter_speed")
    val shutterSpeed: String? = null,

    @field:SerializedName("for_critique")
    val forCritique: Boolean? = null,

    @field:SerializedName("editors_choice_date")
    val editorsChoiceDate: Any? = null,

    @field:SerializedName("hi_res_uploaded")
    val hiResUploaded: Int? = null,

    @field:SerializedName("collections_count")
    val collectionsCount: Int? = null,

    @field:SerializedName("editored_by")
    val editoredBy: EditoredBy? = null,

    @field:SerializedName("purchased")
    val purchased: Boolean? = null,

    @field:SerializedName("taken_at")
    val takenAt: String? = null,

    @field:SerializedName("user_id")
    val userId: Int? = null,

    @field:SerializedName("converted")
    val converted: Boolean? = null,

    @field:SerializedName("comments_count")
    val commentsCount: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("licensing_requested")
    val licensingRequested: Boolean? = null,

    @field:SerializedName("highest_rating_date")
    val highestRatingDate: String? = null,

    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("focal_length")
    val focalLength: String? = null,

    @field:SerializedName("favorites_count")
    val favoritesCount: Int? = null,

    @field:SerializedName("latitude")
    val latitude: Double? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("privacy")
    val privacy: Boolean? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("lens")
    val lens: Any? = null,

    @field:SerializedName("positive_votes_count")
    val positiveVotesCount: Int? = null,

    @field:SerializedName("store_width")
    val storeWidth: Int? = null,

    @field:SerializedName("votes_count")
    val votesCount: Int? = null,

    @field:SerializedName("critiques_callout_dismissed")
    val critiquesCalloutDismissed: Boolean? = null,

    @field:SerializedName("feature")
    val feature: String? = null,

    @field:SerializedName("feature_date")
    val featureDate: String? = null,

    @field:SerializedName("camera")
    val camera: String? = null,

    @field:SerializedName("comments")
    val comments: List<Any?>? = null,

    @field:SerializedName("licensing_suggested")
    val licensingSuggested: Boolean? = null,

    @field:SerializedName("nsfw")
    val nsfw: Boolean? = null,

    @field:SerializedName("license_type")
    val licenseType: Int? = null,

    @field:SerializedName("times_viewed")
    val timesViewed: Int? = null,

    @field:SerializedName("highest_rating")
    val highestRating: Double? = null,

    @field:SerializedName("sales_count")
    val salesCount: Int? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("aperture")
    val aperture: String? = null,

    @field:SerializedName("for_sale_date")
    val forSaleDate: Any? = null,

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("for_sale")
    val forSale: Boolean? = null,

    @field:SerializedName("store_height")
    val storeHeight: Int? = null,

    @field:SerializedName("location")
    val location: Any? = null,

    @field:SerializedName("category")
    val category: Int? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("licensing_status")
    val licensingStatus: Int? = null,

    @field:SerializedName("crop_version")
    val cropVersion: Int? = null
)