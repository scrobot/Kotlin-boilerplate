package com.github.scrobot.kotlin_boilerplate

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.github.scrobot.kotlin_boilerplate.global.*
import com.github.scrobot.kotlin_boilerplate.global.contracts.BottombarAccessor
import com.github.scrobot.kotlin_boilerplate.global.ui.BaseFragment
import com.github.scrobot.kotlin_boilerplate.ui.SplashView
import com.github.scrobot.kotlin_boilerplate.ui.chars.CharactersView
import com.github.scrobot.kotlin_boilerplate.ui.loader.LoaderView
import kotlinx.android.synthetic.main.init_view.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import timber.log.Timber

class MainActivity : AppCompatActivity(), BottombarAccessor {

    val navigationHolder: NavigatorHolder by inject()

    private val STATE_SCREEN_NAME = "state_screen_name"

    val hostedFragment
        get() = supportFragmentManager.findFragmentById(R.id.fragment) as BaseFragment?

    private val navigator = object : SupportAppNavigator(this, R.id.fragment) {

        override fun createActivityIntent(screenKey: String?, data: Any?): Intent? = null

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Views.SPLASH_VIEW -> SplashView()
            Views.LOADING_VIEW -> LoaderView()
            Views.CHARS -> CharactersView()
            Views.LOCATIONS -> ComingSoonFragment()
            Views.EPISODES -> ComingSoonFragment()
            Views.CHARS_DEATAIL -> ComingSoonFragment()
            else -> null
        }

        override fun setupFragmentTransactionAnimation(
                command: Command,
                currentFragment: Fragment?,
                nextFragment: Fragment,
                fragmentTransaction: FragmentTransaction) {

            Timber.d("current: $currentFragment -> next: $nextFragment")
            FragmentAnimationUtils.defaultScreenAnimation(fragmentTransaction)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.init_view)

        if (savedInstanceState == null) {
            navigator.applyCommand(Replace(Views.SPLASH_VIEW, null))
        } else {
            Timber.d("savedInstanceState: ${savedInstanceState.getString(STATE_SCREEN_NAME)}")
        }

        bottomBar.setOnNavigationItemSelectedListener {
            navigator.applyCommand(BackTo( null))

            when(it.itemId) {
                R.id.tab_chars -> navigator.applyCommand(Replace(Views.CHARS, null))
                R.id.tab_locations -> navigator.applyCommand(Replace(Views.LOCATIONS, null))
                R.id.tab_episodes -> navigator.applyCommand(Replace(Views.EPISODES, null))
            }

            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(STATE_SCREEN_NAME, hostedFragment?.navigationId)
        super.onSaveInstanceState(outState)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onResume() {
        super.onResume()

        navigationHolder.setNavigator(navigator)
    }

    override fun onBackPressed() {
        Timber.d(hostedFragment.toString())
        when(hostedFragment) {
            is SplashView -> (hostedFragment as SplashView).getCurrentChildFragment()?.backPressAction()
            else -> hostedFragment?.onBackPressed()
        }
    }

    override fun getBottomBar() = bottomBar

    override fun setActiveBottomBarItem(item: BottombarMenuItem) {
        Timber.d("routerHolder: setActiveBottomBarItem -> $item")
        bottomBar.currentItem = when(item) {
            Person -> 0
            Location -> 1
            Episode -> 2
        }
    }

}
