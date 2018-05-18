package com.kat.news.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

const val DEFAULT_DATE = "dd MMMM yyyy"

internal inline fun <reified T : Any> clazz() = T::class.java

internal fun getDate(date: String): String {
    val format = DateTimeFormat.forPattern(DEFAULT_DATE)
    return DateTime(date).toString(format)
}

internal fun loadImage(context: Context, url: String, imageView: ImageView) {

    fun setMemoryCategory(context: Context) {
        Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL)
    }

//    setMemoryCategory(context)
//    GlideApp.with(context)
//            .load(url)
//            .centerCrop()
//            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//            .into(imageView)
}