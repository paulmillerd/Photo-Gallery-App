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

//            val viewTreeObserver = image_view.viewTreeObserver
//            if (viewTreeObserver.isAlive) {
//                viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                    override fun onGlobalLayout() {
//                        image_view.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                        val estimatedHeight = if (photo?.heightWidthRatio != null && photo.heightWidthRatio != 0.0) {
//                            (image_view.width / photo.heightWidthRatio).toInt()
//                        } else {
//                            WRAP_CONTENT
//                        }
//                        image_view.layoutParams = image_view.layoutParams.also {
//                            it.width = estimatedHeight
//                        }
//                    }
//                })
//            }
        }
    }

    interface GalleryVHCallback {
        fun onPhotoClicked(photo: Photo?)
    }

}