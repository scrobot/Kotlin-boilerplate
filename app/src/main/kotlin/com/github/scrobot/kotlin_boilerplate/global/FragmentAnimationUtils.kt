package com.github.scrobot.kotlin_boilerplate.global

import android.support.v4.app.FragmentTransaction
import com.github.scrobot.kotlin_boilerplate.R


/**
 * Created by alexscrobot on 14.03.18.
 */
object FragmentAnimationUtils {

    fun defaultScreenAnimation(fragmentTransaction: FragmentTransaction) {
        fragmentTransaction.setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
        fragmentTransaction.commitNow()
    }
}