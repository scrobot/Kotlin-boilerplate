package com.github.scrobot.kotlin_boilerplate.global.ui.transformations

import android.graphics.*
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.nio.charset.Charset
import java.security.MessageDigest






class GradientTransfromation(private val colorStart: Int?, private val colorEnd: Int?): BitmapTransformation() {

    private val ID = "com.github.scrobot.kotlin_boilerplate.global.ui.transformations.GradientTransfromation"
    private val ID_BYTES = ID.toByteArray(Charset.forName("UTF-8"))

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID_BYTES)
    }

    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {
        val width = toTransform.width
        val height = toTransform.height

        val config = if (toTransform.config != null) toTransform.config else Bitmap.Config.ARGB_8888
        val bitmap = pool.get(width, height, config)

        val canvas = Canvas(bitmap)
        val paint = Paint()

        canvas.drawBitmap(toTransform, 0f, 0f, paint)

        val shader = LinearGradient(0f, 0f, 0f, height.toFloat(), colorStart ?: 0x000000, colorEnd ?: 0x000000, Shader.TileMode.CLAMP)
        paint.shader = shader
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        return bitmap
    }

}