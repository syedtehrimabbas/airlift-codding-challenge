package com.airlift.codingchallenge.utils.glide

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide


const val BASE_IMAGES_URL = "https://assets.coinlayer.com/icons/"

fun getUrl(imageEndPoint: String?) = "$BASE_IMAGES_URL$imageEndPoint.png"
fun setCircleCropImage(imageView: AppCompatImageView, url: String) {
    val mUrl = getUrl(url)
    Log.d("mUrl", mUrl)
    Glide.with(imageView).load(mUrl)
        .into(imageView)
}
