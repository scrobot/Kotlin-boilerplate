package com.github.scrobot.kotlin_boilerplate.global.extentions

import android.graphics.Bitmap
import android.support.annotation.StringRes
import android.view.Window
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import com.github.scrobot.kotlin_boilerplate.RickAndMortyApp.Companion.context
import com.github.scrobot.kotlin_boilerplate.global.ErrorHandler


/**
 * Created by alexscrobot on 14.11.17.
 */

fun text(@StringRes message: Int) {
    Toast.makeText(context, context.resources.getString(message), Toast.LENGTH_SHORT).show()
}

fun text(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun<T> List<T>.tail(): List<T> {
    if(this.isNotEmpty()) {
        return this.subList(1, this.size)
    }

    return listOf()
}

fun Boolean.toInt() = if(this) 1 else 0

fun Window.takeScreenshot(): Bitmap? {
    return try {
        // create bitmap screen capture
        val v1 = decorView.rootView
        v1.isDrawingCacheEnabled = true
        val bitmap = Bitmap.createBitmap(v1.drawingCache)
        v1.isDrawingCacheEnabled = false

        bitmap
    } catch (e: Throwable) {
        // Several error may come out with file handling or DOM
        e.printStackTrace()
        null
    }
}

fun Any?.serialize(): String? {
    return GsonBuilder().create().toJson(this)
}

inline fun<reified T> String.unserialize(clazz: Class<T>): T? {
    return try {
        GsonBuilder().create().fromJson(this, clazz)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun<T> String.unserializeToList(clazz: Class<T>): List<T> {
    val gson = GsonBuilder().create()

    return gson.fromJson<List<T>>(this, object: TypeToken<List<T>>(){}.type)
}

fun<T> String.unserializeToSet(clazz: Class<T>): Set<T> {
    val gson = GsonBuilder().create()

    return gson.fromJson<Set<T>>(this, object: TypeToken<Set<T>>(){}.type)
}

fun getLocalizedMonthsList(): List<String> {
    val list = mutableListOf<String>()

    for (i in 1..12) {
        val localDate = LocalDate(2018, i, 1)
        list.add(i - 1, localDate.toString("MMM").toUpperCase())
    }

    return list
}

fun String.parseDate(inputFormatPattern: String = "yyyy-MM-dd", outPutFormat: String = "dd MMM yyyy") = try {
        this.createDateTimeFromString(inputFormatPattern)?.toString(outPutFormat)
    } catch (e: IllegalArgumentException) {
        ErrorHandler::handle
        this
    } catch (e: Exception) {
        ErrorHandler::handle
        null
    }

fun String.createDateTimeFromString(input: String) = try {
        DateTime.parse(this, DateTimeFormat.forPattern(input))
    } catch (e: IllegalArgumentException) {
        ErrorHandler::handle
        DateTime.now()
    } catch (e: Exception) {
        ErrorHandler::handle
        null
    }

inline fun Boolean?.isNullOrFalse() = this == null || this == false
