package com.github.scrobot.kotlin_boilerplate.presentation.loader

import com.github.scrobot.kotlin_boilerplate.global.Views
import com.github.scrobot.kotlin_boilerplate.global.viewmodels.RxViewModel
import ru.terrakok.cicerone.Router

class LoaderViewModel(private val router: Router): RxViewModel() {

    fun forward() = router.newRootScreen(Views.CHARS)

}