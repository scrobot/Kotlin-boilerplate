package com.github.scrobot.kotlin_boilerplate.global.preferences

import android.content.Context
import android.content.SharedPreferences
import com.github.scrobot.kotlin_boilerplate.global.Constants
import java.util.*



class PreferenceManager(context: Context): IPreferences {

    private var helper: PreferencesHelper

    init {
        this.helper = PreferencesHelper(context)
    }

    private inner class PreferencesHelper(context: Context) {

        private val pref: SharedPreferences = context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE)

        fun clear() {
            pref.edit().clear().apply()
        }

        fun getBool(name: String): Boolean = pref.getBoolean(name, false)
        fun getBool(name: String, default: Boolean): Boolean = pref.getBoolean(name, default)

        fun setBool(name: String, value: Boolean) {
            pref.edit().putBoolean(name, value).apply()
        }

        fun getString(name: String): String = pref.getString(name, Constants.EMPTY)

        fun getString(name: String, default: String): String = pref.getString(name, default)

        fun setString(name: String, value: String?) {
            pref.edit().putString(name, value).apply()
        }

        fun getInt(name: String): Int = pref.getInt(name, 0)

        fun getInt(name: String, def: Int): Int = pref.getInt(name, def)

        fun setInt(name: String, value: Int) {
            pref.edit().putInt(name, value).apply()
        }

        fun getLong(name: String): Long = pref.getLong(name, 0)

        fun getLong(name: String, def: Long): Long = pref.getLong(name, def)

        fun setLong(name: String, value: Long) {
            pref.edit().putLong(name, value).apply()
        }

        fun setDouble(name: String, value: Double) {
            pref.edit().putString(name, value.toString()).apply()
        }

        fun getDouble(name: String): Double = pref.getString(name, "0").toDouble()

        fun getStringSet(setName: String): MutableSet<String>? =
                pref.getStringSet(setName, HashSet<String>())

        fun setStringSet(setName: String, set: HashSet<String>) {
            pref.edit().putStringSet(setName, set).apply()
        }

    }


}
