package com.paulmillerd.photogalleryapp.gallery

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.paulmillerd.photogalleryapp.R
import com.paulmillerd.photogalleryapp.models.Photo
import kotlinx.android.synthetic.main.gallery_item_layout.view.*

class GalleryViewHolder(itemView: View, private val callback: GalleryVHCallback) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup, callback: GalleryVHCallback): GalleryViewHolder {
            return GalleryViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.gallery_item_layout, parent, false),
                callback
            )
        }
    }

    fun bindItem(photo: Photo?) {
        with(itemView) {
            Glide.with(context)
                .load(photo?.smallUrl)
                .apply(
                    RequestOptions()
                        .placeholder(
                            ColorDrawable(
                                ContextCompat.getColor(context, android.R.color.black)
                            )
                        )
                )
                .into(image_view)

            image_view.setOnClickListener {
                callback.onPhotoClicked(photo)
            }
        }
    }

    interface GalleryVHCallback {
        fun onPhotoClicked(photo: Photo?)
    }

}