package com.paulmillerd.photogalleryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.paulmillerd.photogalleryapp.R
import com.paulmillerd.photogalleryapp.viewModels.GalleryViewModel
import kotlinx.android.synthetic.main.gallery_fragment_layout.*

class GalleryFragment : Fragment() {

    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gallery_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gallery_recycler_view.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
    }

}