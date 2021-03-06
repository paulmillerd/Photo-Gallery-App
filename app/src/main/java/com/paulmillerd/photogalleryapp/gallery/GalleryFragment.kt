package com.paulmillerd.photogalleryapp.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.paulmillerd.photogalleryapp.PhotoGalleryApp
import com.paulmillerd.photogalleryapp.R
import com.paulmillerd.photogalleryapp.models.Photo
import com.paulmillerd.photogalleryapp.repositories.IGalleryRepository
import com.paulmillerd.photogalleryapp.viewModels.GalleryViewModel
import kotlinx.android.synthetic.main.gallery_fragment_layout.*
import javax.inject.Inject

class GalleryFragment : Fragment(), GalleryViewHolder.GalleryVHCallback {

    @Inject
    lateinit var galleryRepository: IGalleryRepository

    private lateinit var viewModel: GalleryViewModel
    private var callback: GalleryFragmentCallback? = null
    private val galleryAdapter = GalleryAdapter(this)

    private val photosObserver = Observer<PagedList<Photo>> { photos ->
        galleryAdapter.submitList(photos)
        swipe_refresh_layout.isRefreshing = false
    }

    fun setCallback(callback: GalleryFragmentCallback) {
        this.callback = callback
    }

    override fun onPhotoClicked(photo: Photo?) {
        callback?.onPhotoClicked(photo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gallery_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gallery_recycler_view.adapter = galleryAdapter
        gallery_recycler_view.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        swipe_refresh_layout.setOnRefreshListener {
            galleryAdapter.submitList(null)
            viewModel.refreshPopularPhotos()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let { ctx ->
            PhotoGalleryApp.getAppComponent(ctx).inject(this)
            viewModel = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
            viewModel.init(galleryRepository)
            viewModel.popularPhotos?.observe(this, photosObserver)
            viewModel.refreshPopularPhotos()
        }
    }

    interface GalleryFragmentCallback {
        fun onPhotoClicked(photo: Photo?)
    }

}