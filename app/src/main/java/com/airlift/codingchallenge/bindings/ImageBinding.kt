package com.airlift.codingchallenge.bindings

import androidx.databinding.BindingAdapter
import com.airlift.codingchallenge.utils.glide.setCircleCropImage
import com.google.android.material.imageview.ShapeableImageView

object ImageBinding {

    @JvmStatic
    @BindingAdapter(value = ["imageEndPoint"], requireAll = false)
    fun loadCurrencyAvatar(
        imageView: ShapeableImageView,
        imageEndPoint: String?,
    ) {
        setCircleCropImage(imageView, imageEndPoint ?: "")
    }

}
