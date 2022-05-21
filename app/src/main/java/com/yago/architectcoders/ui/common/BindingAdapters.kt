package com.yago.architectcoders.ui.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("url")
fun ImageView.bindUrl(url: String?) {
    if (url != null) loadUrl(url)
}

@BindingAdapter("visible")
fun View.setVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("imageCode")
fun ImageView.bindImage(code: Int?) {
    when (code) {
        804 -> this.bindUrl("https://estaticos.muyinteresante.es/uploads/images/gallery/5f9a9dec5bafe87eb4bbcf9f/1-nubes-en-el-cielo.jpg")
        else -> this.bindUrl("https://static8.depositphotos.com/1451970/915/v/600/depositphotos_9150302-stock-illustration-the-sun.jpg")
    }
}