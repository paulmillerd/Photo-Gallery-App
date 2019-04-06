package com.paulmillerd.photogalleryapp.fullscreenImage

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.paulmillerd.photogalleryapp.DateUtils.Companion.formatDate
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
        populateUi(arguments?.getSerializable(PHOTO) as Photo?)

        main_image_view.setOnClickListener {
            val newVisibility = if (info_group.isVisible) GONE else VISIBLE
            TransitionManager.beginDelayedTransition(info_group.parent as ViewGroup)
            info_group.visibility = newVisibility
        }

        info_background.setOnClickListener { /* consume click */ }
    }

    private fun populateUi(photo: Photo?) {
        Glide.with(this)
            .load(photo?.bigUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .thumbnail(
                Glide.with(this)
                    .load(photo?.smallUrl)
            )
            .into(main_image_view)

        title.text = photo?.name

        if (!TextUtils.isEmpty(photo?.description)) {
            description.visibility = VISIBLE
            description.text = HtmlCompat.fromHtml(photo?.description ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)
        } else {
            description.visibility = GONE
        }

        if (photo?.dateTaken != null && photo.username != null) {
            taken_by.text = String.format(getString(R.string.taken_by_on), photo.username, formatDate(photo.dateTaken))
            taken_by.visibility = VISIBLE
        } else if (photo?.username != null) {
            taken_by.text = String.format(getString(R.string.taken_by), photo.username)
            taken_by.visibility = VISIBLE
        } else {
            taken_by.visibility = GONE
        }
    }

}