package com.github.scrobot.kotlin_boilerplate.global

import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.view.View

/**
 * Created by Saikou on 20.03.18.
 */
object SpringAnimationUtils {

    fun setSpringAnimation (view: View) {
        val scaleX = SpringAnimation(view, DynamicAnimation.SCALE_X, 1F)
        val scaleY = SpringAnimation(view, DynamicAnimation.SCALE_Y, 1F)

        scaleX.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        scaleY.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY

        scaleX.setStartValue(1.05F).start()
        scaleY.setStartValue(1.05F).start()
    }

}