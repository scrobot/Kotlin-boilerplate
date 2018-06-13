package com.github.scrobot.kotlin_boilerplate.global.contracts

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.github.scrobot.kotlin_boilerplate.global.BottombarMenuItem

/**
 * Created by alexscrobot on 20.03.18.
 */
interface BottombarAccessor {

    fun getBottomBar(): BottomNavigationViewEx
    fun setActiveBottomBarItem(item: BottombarMenuItem)

}