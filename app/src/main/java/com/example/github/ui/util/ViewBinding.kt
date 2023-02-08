package com.example.github.ui.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.github.R


@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {

        Glide.with(imageView.context).load(imageUrl).placeholder(R.drawable.baseline_account_circle_24).circleCrop().into(imageView)
    }
}

