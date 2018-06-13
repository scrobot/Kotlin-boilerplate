package com.github.scrobot.kotlin_boilerplate.global.extentions

import android.graphics.Bitmap


fun Bitmap.getResizedBitmap(maxSize: Int): Bitmap {
    var width = this.width
    var height = this.height

    val bitmapRatio = width.toFloat() / height.toFloat()
    if (bitmapRatio > 1) {
        width = maxSize
        height = (width / bitmapRatio).toInt()
    } else {
        height = maxSize
        width = (height * bitmapRatio).toInt()
    }

    return Bitmap.createScaledBitmap(this, width, height, true)
}