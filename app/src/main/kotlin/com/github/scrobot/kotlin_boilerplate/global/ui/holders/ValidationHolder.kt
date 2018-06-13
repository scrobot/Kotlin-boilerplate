package com.github.scrobot.kotlin_boilerplate.global.ui.holders

import java.util.*

/**
 * Created by alexscrobot on 16.03.18.
 */
data class ValidationHolder(val error: String? = null, val fields: Array<String>? = null) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValidationHolder

        if (error != other.error) return false
        if (!Arrays.equals(fields, other.fields)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = error?.hashCode() ?: 0
        result = 31 * result + Arrays.hashCode(fields)
        return result
    }
}