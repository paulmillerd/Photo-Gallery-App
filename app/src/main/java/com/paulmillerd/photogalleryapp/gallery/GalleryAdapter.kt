package com.paulmillerd.photogalleryapp.gallery

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.paulmillerd.photogalleryapp.models.Photo

class GalleryAdapter(private val callback: GalleryViewHolder.GalleryVHCallback) :
    PagedListAdapter<Photo, GalleryViewHolder>(ChildrenDiffer()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.create(parent, callback)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class ChildrenDiffer : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.smallUrl == newItem.smallUrl &&
                    oldItem.username == newItem.username
        }
    }

}