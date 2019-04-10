package com.paulmillerd.photogalleryapp.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.paulmillerd.photogalleryapp.api.GalleryService
import com.paulmillerd.photogalleryapp.api.responseModels.GalleryPageResponse
import com.paulmillerd.photogalleryapp.modelConverters.IPhotoFromApiConverter
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.models.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryRepository(
    private val galleryService: GalleryService,
    private val photoFromApiConverter: IPhotoFromApiConverter
) : IGalleryRepository {

    private val errorsLiveData = MutableLiveData<Int?>()

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

    override fun getErrors(): LiveData<Int?> = errorsLiveData

    private fun fetchPage(
        feature: Feature, imageSizes: List<ImageSize>, page: Int,
        initCallback: PageKeyedDataSource.LoadInitialCallback<Int, Photo>?,
        callback: PageKeyedDataSource.LoadCallback<Int, Photo>?
    ) {
        galleryService.getPhotos(feature = feature.value, imageSizes = imageSizes.map { it.value }, page = page)
            .enqueue(object : Callback<GalleryPageResponse> {
                override fun onResponse(call: Call<GalleryPageResponse>, response: Response<GalleryPageResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        response.body()?.let { processPageResponseBody(it, initCallback, callback) }
                    } else {
                        sendError(response.code())
                    }
                }

                override fun onFailure(call: Call<GalleryPageResponse>, t: Throwable) {
                    sendError()
                    t.printStackTrace()
                }
            })
    }

    private fun processPageResponseBody(
        responseBody: GalleryPageResponse,
        initCallback: PageKeyedDataSource.LoadInitialCallback<Int, Photo>?,
        callback: PageKeyedDataSource.LoadCallback<Int, Photo>?
    ) {
        val photos = responseBody.photos?.map {
            photoFromApiConverter.convertApiModelToPhoto(it)
        } as MutableList<Photo>
        val currentPage = responseBody.currentPage ?: 0
        if (initCallback != null) {
            initCallback.onResult(
                photos, 0, responseBody.totalItems ?: 0,
                null, currentPage + 1
            )
        } else {
            callback?.onResult(photos, currentPage + 1)
        }
    }

    private fun sendError(responseCode: Int? = null) {
        errorsLiveData.postValue(responseCode)
    }

}