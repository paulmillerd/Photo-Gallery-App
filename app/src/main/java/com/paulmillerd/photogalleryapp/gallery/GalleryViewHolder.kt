package com.paulmillerd.photogalleryapp.gallery

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.paulmillerd.photogalleryapp.R
import com.paulmillerd.photogalleryapp.models.Photo
import com.paulmillerd.photogalleryapp.models.PhotoRow
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

    fun bindItem(photoRow: PhotoRow?) {
        itemView.photo_row_linear_layout.removeAllViews()
        itemView.postInvalidate()
        photoRow?.forEachIndexed { index, photo ->
            //            val textView = TextView(itemView.context)
//            textView.layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, photoRow.getWeightOfPhotoAt(index).toFloat())
//            textView.text = "${photo.id}, ${photo.smallUrl}, ${photoRow.getWeightOfPhotoAt(index)}"
//            textView.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.white))
//            itemView.photo_row_linear_layout.addView(textView)
            val imageView = ImageView(itemView.context)
            imageView.layoutParams = LinearLayout.LayoutParams(
                0,
                WRAP_CONTENT,
                photoRow.getWeightOfPhotoAt(index).toFloat()
            )
            imageView.adjustViewBounds = true
            itemView.photo_row_linear_layout.addView(imageView)
            Glide.with(imageView)
                .load(photo.smallUrl)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.requestLayout()
                        return false
                    }
                })
                .apply(
                    RequestOptions()
                        .placeholder(
                            ColorDrawable(
                                ContextCompat.getColor(itemView.context, android.R.color.black)
                            )
                        )
                )
                .into(imageView)

            imageView.setOnClickListener {
                callback.onPhotoClicked(photo)
            }
        }
    }

    interface GalleryVHCallback {
        fun onPhotoClicked(photo: Photo?)
    }

}