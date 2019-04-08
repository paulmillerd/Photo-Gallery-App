package com.paulmillerd.photogalleryapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.paulmillerd.photogalleryapp.models.Feature
import com.paulmillerd.photogalleryapp.models.ImageSize
import com.paulmillerd.photogalleryapp.repositories.IGalleryRepository
import com.paulmillerd.photogalleryapp.viewModels.GalleryViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class GalleryViewModelTest {

    private lateinit var galleryViewModel: GalleryViewModel

    @Mock
    private lateinit var galleryRepository: IGalleryRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setupGalleryViewModel() {
        MockitoAnnotations.initMocks(this)
        galleryViewModel = GalleryViewModel()
        galleryViewModel.init(galleryRepository)
        galleryViewModel.popularPhotos?.observeForever { }
    }

    @Test
    fun refreshPopularPhotos_getFeature() {
        galleryViewModel.refreshPopularPhotos()
        verify(galleryRepository).getFeature(Feature.POPULAR, listOf(ImageSize.SMALL, ImageSize.LARGE))
    }

}