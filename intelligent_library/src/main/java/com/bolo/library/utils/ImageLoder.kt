package com.bolo.library.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Create by bolo on 2018/5/25
 */
class GlideWrapper {
    var url: String? = null
    var image: ImageView? = null
}

fun load(init: GlideWrapper.() -> Unit) {
    val wrap = GlideWrapper()
    wrap.init()
    execute(wrap)
}

fun ImageView.get(url: String?) = Glide.with(context).asBitmap().load(url)

private fun execute(wrap: GlideWrapper) {
    wrap.image?.let {
        var request = it.get(wrap.url).into(it)
    }
}

fun ImageView.loadUrl(url: String) {
    Glide.with(context)
            .asBitmap()
            .load(url)
            .into(this)
}