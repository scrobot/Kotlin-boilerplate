package com.github.scrobot.kotlin_boilerplate.business.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alexscrobot on 16.03.18.
 */
data class ResponseWrapper<T>(
        @SerializedName("code")
        @Expose
        val code: Int = 200,
        @SerializedName("throwable")
        @Expose
        val throwable: Throwable? = null
) {

    @SerializedName("response_time")
    @Expose
    var time: Long = System.currentTimeMillis()
    @SerializedName("info")
    @Expose
    var info: Info? = null
    @SerializedName("results")
    @Expose
    var results: List<T>? = null

    val error: Boolean
        get() = throwable != null

    inner class Info {

        @SerializedName("count")
        @Expose
        var count: Int = 0
        @SerializedName("pages")
        @Expose
        var pages: Int = 0
        @SerializedName("next")
        @Expose
        var next: String? = null
        @SerializedName("prev")
        @Expose
        var prev: String? = null

    }

}