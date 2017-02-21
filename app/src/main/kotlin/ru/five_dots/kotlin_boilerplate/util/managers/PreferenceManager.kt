package com.gitlab.softeamco.likersapp.util.managers

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import ru.five_dots.kotlin_boilerplate.util.Constants
import java.util.*

class PreferenceManager {

    lateinit private var helper: PreferencesHelper
    lateinit private var gson: Gson
    lateinit private var context: Context

    constructor(context: Context) {
        this.gson = GsonBuilder().create()
        this.helper = PreferencesHelper(context)
        this.context = context
    }

    fun hasSubscription(): Boolean {
        return helper.getBool(Constants.SUBSCRIPTION)
    }

    fun setSubscription() {
        helper.setBool(Constants.SUBSCRIPTION, true)
    }

    fun saveCookie(s: String, s1: String) {
        helper.setString(s, s1)
    }

    fun getCookie(name: String): String? {
        val c = helper.getString(name)
        if(c == Constants.EMPTY) {
            return null
        }

        return c
    }

    fun clearCoockies() {
        helper.setString(Constants.COOKIES.CSRF_TOKEN, Constants.EMPTY)
        helper.setString(Constants.COOKIES.DS_USER,    Constants.EMPTY)
        helper.setString(Constants.COOKIES.DS_USER_ID, Constants.EMPTY)
        helper.setString(Constants.COOKIES.MID,        Constants.EMPTY)
        helper.setString(Constants.COOKIES.SESSION_ID, Constants.EMPTY)
    }

    private inner class PreferencesHelper {

        private val mPref: SharedPreferences

        constructor(context: Context) {
            this.mPref = context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE)
        }

        fun clear() {
            mPref.edit().clear().apply()
        }

        fun getBool(name: String): Boolean {
            return mPref.getBoolean(name, false)
        }

        fun setBool(name: String, value: Boolean) {
            mPref.edit().putBoolean(name, value).apply()
        }

        fun getString(name: String): String {
            return mPref.getString(name, Constants.EMPTY)
        }

        fun setString(name: String, value: String) {
            mPref.edit().putString(name, value).apply()
        }

        fun getInt(name: String): Int {
            return mPref.getInt(name, 0)
        }

        fun getInt(name: String, def: Int): Int {
            return mPref.getInt(name, def)
        }

        fun setInt(name: String, value: Int) {
            mPref.edit().putInt(name, value).apply()
        }

        fun setDouble(name: String, value: Double) {
            mPref.edit().putString(name, value.toString()).apply()
        }

        fun getDouble(name: String): Double {
            return mPref.getString(name, "0").toDouble()
        }

        fun getStringSet(setName: String): MutableSet<String>? {
            return mPref.getStringSet(setName, HashSet<String>())
        }

        fun setStringSet(setName: String, set: HashSet<String>) {
            mPref.edit().putStringSet(setName, set).apply()
        }

    }

}
