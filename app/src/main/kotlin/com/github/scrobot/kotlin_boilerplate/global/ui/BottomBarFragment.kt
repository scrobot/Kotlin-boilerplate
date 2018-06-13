package com.github.scrobot.kotlin_boilerplate.global.ui

import android.os.Bundle
import android.view.View
import com.github.scrobot.kotlin_boilerplate.global.extentions.vis

/**
 * Created by alexscrobot on 20.03.18.
 */
abstract class BottomBarFragment: BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomBarAccessor?.getBottomBar()?.vis { true }
    }
}