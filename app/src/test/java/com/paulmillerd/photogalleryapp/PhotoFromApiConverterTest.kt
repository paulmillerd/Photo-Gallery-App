package com.paulmillerd.photogalleryapp

import com.google.gson.Gson
import com.paulmillerd.photogalleryapp.api.responseModels.PhotosItem
import com.paulmillerd.photogalleryapp.modelConverters.PhotoFromApiConverter
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import java.util.*

class PhotoFromApiConverterTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var dateUtils: IDateUtils

    @InjectMocks
    lateinit var photoFromApiConverter: PhotoFromApiConverter

    @Test
    fun convertApiModelToPhoto_withDate() {
        `when`(dateUtils.parseIso8601Date("2018-12-03T04:50:48-05:00")).thenReturn(Date(1543830648))
        val photosItem = Gson().fromJson(PHOTO_RESPONSE_WITH_DATE, PhotosItem::class.java)
        val photo = photoFromApiConverter.convertApiModelToPhoto(photosItem)
        assertEquals(301714081.toLong(), photo.id)
        assertEquals("His Highness !", photo.name)
        assertEquals(
            "Nimbus of a King! The lion king with his distinguished presence on a glorious day.",
            photo.description
        )
        assertEquals(99.9, photo.rating)
        assertEquals(
            "https://drscdn.500px.org/photo/301714081/m%3D2048_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=54258fc962cd154be920534795474e248e8ec168c09c496509f33f649ea1931d",
            photo.bigUrl
        )
        assertEquals(
            "https://drscdn.500px.org/photo/301714081/h%3D300_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=c312b9b1b680e455e4b113c2a08d24d1f3196612da3453b7ac017d94177c1732",
            photo.smallUrl
        )
        assertEquals("cvsk", photo.username)
        assertEquals(0.5625, photo.heightWidthRatio)
        assertEquals(1543830648.toLong(), photo.dateTaken?.time)
    }

    companion object {
        const val PHOTO_RESPONSE_WITH_DATE = """{
"highest_rating_date": "2019-04-10T14:13:09-04:00",
"converted_bits": 0,
"exclude_gads": false,
"camera": "Nikon D850",
"voted": false,
"positive_votes_count": 2574,
"licensing_requested": false,
"converted": false,
"comments": [],
"disliked": false,
"taken_at": "2018-12-03T04:50:48-05:00",
"hi_res_uploaded": 0,
"for_critique": false,
"user": {
"id": 23240807,
"avatars": {
"small": {
"https": "https://drscdn.500px.org/user_avatar/23240807/q%3D85_w%3D50_h%3D50/v2?webp=true&v=40&sig=367b7f537cd4c891467cf7b21fdcd069c7d603a90d6a50e15a2a460fe6360ef2"
},
"default": {
"https": "https://drscdn.500px.org/user_avatar/23240807/q%3D85_w%3D300_h%3D300/v2?webp=true&v=40&sig=014f52924eb43fa16e92d9f06b1ddd46d72b4a2e7581fc40188c00f76bb7baf2"
},
"large": {
"https": "https://drscdn.500px.org/user_avatar/23240807/q%3D85_w%3D100_h%3D100/v2?webp=true&v=40&sig=25538427f8c4d1538b4c94fb2c32a65d053bb3f8f794fefbd9a6b7ebba1bf456"
},
"tiny": {
"https": "https://drscdn.500px.org/user_avatar/23240807/q%3D85_w%3D30_h%3D30/v2?webp=true&v=40&sig=4570054b8f3af40851798fc4fb7d76c7c75167cd26679c41c1d1435718ba9c50"
}
},
"lastname": "",
"userpic_https_url": "https://drscdn.500px.org/user_avatar/23240807/q%3D85_w%3D300_h%3D300/v2?webp=true&v=40&sig=014f52924eb43fa16e92d9f06b1ddd46d72b4a2e7581fc40188c00f76bb7baf2",
"country": "INDIA",
"firstname": "Sunil ",
"userpic_url": "https://drscdn.500px.org/user_avatar/23240807/q%3D85_w%3D300_h%3D300/v2?webp=true&v=40&sig=014f52924eb43fa16e92d9f06b1ddd46d72b4a2e7581fc40188c00f76bb7baf2",
"cover_url": "https://drscdn.500px.org/user_cover/23240807/q%3D65_m%3D2048/v2?webp=true&v=4&sig=7081b18c8544f8f158e9e78de11870ae7c526e75d1bb6dafd3f402af1669835d",
"store_on": true,
"upgrade_status": 0,
"fullname": "Sunil ",
"city": "NEW DELHI",
"username": "cvsk",
"affection": 1033046,
"usertype": 0
},
"watermark": false,
"image_url": [
"https://drscdn.500px.org/photo/301714081/h%3D300_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=c312b9b1b680e455e4b113c2a08d24d1f3196612da3453b7ac017d94177c1732",
"https://drscdn.500px.org/photo/301714081/m%3D2048_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=54258fc962cd154be920534795474e248e8ec168c09c496509f33f649ea1931d"
],
"category": 11,
"status": 1,
"crop_version": 0,
"licensing_suggested": false,
"critiques_callout_dismissed": false,
"feature_date": "2019-04-10T00:21:52+00:00",
"focal_length": "500",
"collections_count": 83,
"location": null,
"sales_count": 0,
"for_sale": false,
"iso": "640",
"comments_count": 136,
"editors_choice": false,
"image_format": "jpeg",
"name": "His Highness !",
"width": 8256,
"editors_choice_date": null,
"longitude": 76.9366376,
"shutter_speed": "0/1",
"licensing_status": 0,
"store_height": 4644,
"lens": null,
"times_viewed": 12888,
"license_type": 0,
"profile": true,
"purchased": false,
"is_free_photo": false,
"latitude": 8.5241391,
"nsfw": false,
"votes_count": 2574,
"rating": 99.9,
"created_at": "2019-04-09T20:06:11-04:00",
"highest_rating": 99.9,
"store_width": 8256,
"request_to_buy_enabled": true,
"id": 301714081,
"user_id": 23240807,
"aperture": "8",
"for_sale_date": null,
"privacy": false,
"license_requests_enabled": true,
"description": "Nimbus of a King! The lion king with his distinguished presence on a glorious day.",
"favorites_count": 0,
"images": [
{
"size": 20,
"format": "jpeg",
"https_url": "https://drscdn.500px.org/photo/301714081/h%3D300_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=c312b9b1b680e455e4b113c2a08d24d1f3196612da3453b7ac017d94177c1732",
"url": "https://drscdn.500px.org/photo/301714081/h%3D300_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=c312b9b1b680e455e4b113c2a08d24d1f3196612da3453b7ac017d94177c1732"
},
{
"size": 2048,
"format": "jpeg",
"https_url": "https://drscdn.500px.org/photo/301714081/m%3D2048_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=54258fc962cd154be920534795474e248e8ec168c09c496509f33f649ea1931d",
"url": "https://drscdn.500px.org/photo/301714081/m%3D2048_k%3D1_a%3D1/v2?client_application_id=8016&webp=true&sig=54258fc962cd154be920534795474e248e8ec168c09c496509f33f649ea1931d"
}
],
"liked": false,
"height": 4644,
"feature": "popular",
"editored_by": {},
"url": "/photo/301714081/his-highness-by-sunil"
}"""
    }

}