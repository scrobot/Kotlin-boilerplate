package com.github.scrobot.kotlin_boilerplate.global.di.modules

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import com.github.scrobot.kotlin_boilerplate.presentation.chars.CharactersViewModel
import com.github.scrobot.kotlin_boilerplate.presentation.loader.LoaderViewModel

object ViewModelModule {

    val beans = applicationContext {

        viewModel { LoaderViewModel(get()) }
        viewModel { CharactersViewModel(get(), get()) }

//        viewModel { params -> AllowPermissionViewModel(params["alertDialogInstance"], params["rxPermissions"], get(), get(), get()) }
    }

}