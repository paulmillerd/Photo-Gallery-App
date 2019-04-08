# Photo Gallery App

## Building the app

The app can be built in Android Studio 3.3.2 or later. Before building, you must create a Kotlin file in `app/src/main/java/com/paulmillerd/photogalleryapp/` containing your consumer key, like so:

```kotlin
package com.paulmillerd.photogalleryapp

const val GALLERY_CONSUMER_KEY = "your_consumer_key"
```

## Features

* Images in recycler view preserve their dimensions (no cropping).
* Pull down to refresh the gallery.
* Tap image in gallery view to see fullscreen view.
* Pinch to zoom in fullscreen view. Tap image to show and hide photo info.
* Supports phone rotation.
* Supports Android 4.4 (API level 19) and later.

## Issues

The images shift around when scrolling back up the gallery. This seems to be due to the view holders having to re-adjust their heights. A fix could be to determine the image height (from the meta data) before downloading the image and using this height to set the view holder height. More time would be needed to get this working.
