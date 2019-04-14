package com.paulmillerd.photogalleryapp.gallery

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.paulmillerd.photogalleryapp.models.PhotoRow

class GalleryAdapter(private val callback: GalleryViewHolder.GalleryVHCallback) :
    PagedListAdapter<PhotoRow, GalleryViewHolder>(ChildrenDiffer()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.create(parent, callback)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class ChildrenDiffer : DiffUtil.ItemCallback<PhotoRow>() {
        override fun areItemsTheSame(oldItem: PhotoRow, newItem: PhotoRow): Boolean {
            if (oldItem.size != newItem.size) {
                return false
            }
            oldItem.forEachIndexed { index, photo ->
                if (photo.id != newItem[index].id) {
                    return false
                }
            }
            return true
        }

        override fun areContentsTheSame(oldItem: PhotoRow, newItem: PhotoRow): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }

}