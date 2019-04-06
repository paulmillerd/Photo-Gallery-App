package com.paulmillerd.photogalleryapp.fullscreenImage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.paulmillerd.photogalleryapp.R
import com.paulmillerd.photogalleryapp.models.Photo
import kotlinx.android.synthetic.main.fullscreen_image_layout.*

class FullscreenImageFragment : Fragment() {

    companion object {
        const val PHOTO = "PHOTO"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fullscreen_image_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photo = arguments?.getSerializable(PHOTO) as Photo?

        Glide.with(this)
            .load(photo?.bigUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .thumbnail(
                Glide.with(this)
                    .load(photo?.smallUrl)
            )
            .into(main_image_view)
    }

}