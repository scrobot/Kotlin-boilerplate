package com.github.scrobot.kotlin_boilerplate.global.extentions

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics


/**
 * Created by alexscrobot on 14.11.17.
 */

fun Context.openLink(url: String?, title: String = "Выберите браузер") {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    val browserChooserIntent = Intent.createChooser(browserIntent, title)
    startActivity(browserChooserIntent)
}

fun Context.drawable(@DrawableRes drawable: Int) = ContextCompat.getDrawable(this, drawable)

fun CharSequence.trimTrailingWhitespace(): CharSequence {

    var i = this.length

    // loop back to the first non-whitespace character
    while (--i >= 0 && Character.isWhitespace(this[i])) {
    }

    return this.subSequence(0, i + 1)
}

fun Context.convertDpToPx(dp: Int): Int {
    return Math.round(dp * (resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))

}

fun Context.convertDpToPx(dp: Float): Float {
    return Math.round(dp * (resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).toFloat()
}

fun Context.convertPxToDp(px: Int): Int {
    return Math.round(px / (Resources.getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}

fun Context.getRealPathFromURI(contentUri: Uri): String {
    var cursor: Cursor? = null
    try {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        cursor = contentResolver.query(contentUri, proj, null, null, null)
        val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(column_index)
    } finally {
        if (cursor != null) {
            cursor.close()
        }
    }
}