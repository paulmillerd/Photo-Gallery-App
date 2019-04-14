package com.paulmillerd.photogalleryapp.models

class PhotoRow : ArrayList<Photo>() {

    companion object {
        const val TARGET_RATIO = 1.0 / 3.0
    }

    fun getHeightWidthRatio(): Double {
        val denominator = this.fold(0.0) { acc, photo ->
            if (photo.heightWidthRatio != null && photo.heightWidthRatio != 0.0) {
                acc + (1.0 / photo.heightWidthRatio)
            } else {
                acc
            }
        }

        return if (denominator != 0.0) {
            1.0 / denominator
        } else {
            0.0
        }
    }

    fun previewHeightWidthRatio(candidatePhoto: Photo): Double {
        val currentRatio = getHeightWidthRatio()
        if (currentRatio == 0.0) {
            return candidatePhoto.heightWidthRatio ?: 0.0
        }
        candidatePhoto.heightWidthRatio?.let {
            if (it != 0.0) {
                return 1.0 / ((1.0 / currentRatio) + (1.0 / it))
            }
        }
        return 0.0
    }

    fun getWeightOfPhotoAt(index: Int): Double {
        val photo = this[index]
        return if (photo.heightWidthRatio == null || photo.heightWidthRatio == 0.0) {
            0.0
        } else {
            getHeightWidthRatio() / photo.heightWidthRatio
        }
    }

}