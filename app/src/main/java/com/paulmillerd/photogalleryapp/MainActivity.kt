package com.paulmillerd.photogalleryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulmillerd.photogalleryapp.fragments.GalleryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(GalleryFragment(), null)
            .commit()
    }
}
