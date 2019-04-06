package com.paulmillerd.photogalleryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulmillerd.photogalleryapp.fullscreenImage.FullscreenImageFragment
import com.paulmillerd.photogalleryapp.fullscreenImage.FullscreenImageFragment.Companion.PHOTO
import com.paulmillerd.photogalleryapp.gallery.GalleryFragment
import com.paulmillerd.photogalleryapp.models.Photo

class MainActivity : AppCompatActivity(), GalleryFragment.GalleryFragmentCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.content_frame, GalleryFragment().also {
                it.setCallback(this)
            })
            .commit()
    }

    override fun onPhotoClicked(photo: Photo?) {
        supportFragmentManager.beginTransaction()
            .add(R.id.content_frame, FullscreenImageFragment().also {
                it.arguments = Bundle().also { args ->
                    args.putSerializable(PHOTO, photo)
                }
            })
            .addToBackStack(null)
            .commit()
    }
}
