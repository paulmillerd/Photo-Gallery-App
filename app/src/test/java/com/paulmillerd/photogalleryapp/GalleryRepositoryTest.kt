package com.paulmillerd.photogalleryapp

import com.paulmillerd.photogalleryapp.api.GalleryService
import com.paulmillerd.photogalleryapp.api.responseModels.GalleryPageResponse
import com.paulmillerd.photogalleryapp.repositories.GalleryRepository
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GalleryRepositoryTest {

    private lateinit var galleryRepository: GalleryRepository

    @Mock
    private lateinit var galleryService: GalleryService

    @Captor
    private lateinit var galleryPageResponseCallbackCaptor: ArgumentCaptor<GalleryPageResponse>

    @Before
    fun setupTests() {
        MockitoAnnotations.initMocks(this)
//        galleryRepository = GalleryRepository(galleryService)
    }

    @Test
    fun fetchPage_getPhotos() {
//        galleryRepository.
    }

}