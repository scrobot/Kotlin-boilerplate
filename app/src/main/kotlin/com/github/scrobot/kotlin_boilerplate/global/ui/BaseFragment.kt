package com.github.scrobot.kotlin_boilerplate.global.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.github.scrobot.kotlin_boilerplate.global.contracts.BottombarAccessor
import com.github.scrobot.kotlin_boilerplate.global.extentions.vis

/**
 * Created by alexscrobot on 15.12.17.
 */
abstract class BaseFragment: Fragment() {

    abstract val layout: Int
    abstract val navigationId: String

    open val fragmentSoftInputMode: Int? = null

    val bottomBarAccessor: BottombarAccessor? by lazy { activity as BottombarAccessor }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        retainInstance = true
    }

    override fun onDestroy() {
        if(fragmentSoftInputMode != null) {
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }

        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(layout, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(fragmentSoftInputMode != null) {
            activity?.window?.setSoftInputMode(fragmentSoftInputMode as Int)
        } else {
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        }

        bottomBarAccessor?.getBottomBar()?.vis { false }
    }

    fun onBackPressed() {
        backPressAction()
    }

    open fun backPressAction() {}
}