package com.paulmillerd.photogalleryapp.repositories

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.paulmillerd.photogalleryapp.galleryApi.GalleryService
import com.paulmillerd.photogalleryapp.galleryApi.responseModels.GalleryPageResponse
import com.paulmillerd.photogalleryapp.modelConverters.PhotoFromApiConverter
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GalleryRepository @Inject constructor(private val galleryService: GalleryService) : IGalleryRepository {

    override fun getFeature(feature: Feature, imageSizes: List<ImageSize>): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder<Int, Photo>(object : DataSource.Factory<Int, Photo>() {
            override fun create(): DataSource<Int, Photo> {
                return object : PageKeyedDataSource<Int, Photo>() {
                    override fun loadInitial(
                        params: LoadInitialParams<Int>,
                        callback: LoadInitialCallback<Int, Photo>
                    ) {
                        fetchPage(feature, imageSizes, 1, callback, null)
                    }

                    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
                        fetchPage(feature, imageSizes, params.key, null, callback)
                    }

                    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
                        fetchPage(feature, imageSizes, params.key, null, callback)
                    }
                }
            }
        }, 10).build()
    }

    private fun fetchPage(
        feature: Feature, imageSizes: List<ImageSize>, afterKey: Int,
        initCallback: PageKeyedDataSource.LoadInitialCallback<Int, Photo>?,
        callback: PageKeyedDataSource.LoadCallback<Int, Photo>?
    ) {
        val imageSizeValues = imageSizes.map { it.value }
        galleryService.getPhotos(feature = feature.value, imageSizes = imageSizeValues, page = afterKey)
            .enqueue(object : Callback<GalleryPageResponse> {
                override fun onResponse(call: Call<GalleryPageResponse>, response: Response<GalleryPageResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        val photos = response.body()?.photos?.map {
                            PhotoFromApiConverter.convertApiModelToPhoto(it)
                        } as MutableList<Photo>
                        val currentPage = response.body()?.currentPage ?: 0
                        if (initCallback != null) {
                            initCallback.onResult(photos, null, currentPage + 1)
                        } else {
                            callback?.onResult(photos, currentPage + 1)
                        }
                    }
                }

                override fun onFailure(call: Call<GalleryPageResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

}