package com.github.scrobot.kotlin_boilerplate.ui.loader

import android.os.Bundle
import android.view.View
import com.github.scrobot.kotlin_boilerplate.R
import com.github.scrobot.kotlin_boilerplate.global.ErrorHandler
import com.github.scrobot.kotlin_boilerplate.global.GlideApp
import com.github.scrobot.kotlin_boilerplate.global.Views
import com.github.scrobot.kotlin_boilerplate.global.extentions.ui
import com.github.scrobot.kotlin_boilerplate.global.ui.BaseFragment
import com.github.scrobot.kotlin_boilerplate.presentation.loader.LoaderViewModel
import io.reactivex.Observable
import kotlinx.android.synthetic.main.loading_view.*
import org.koin.android.architecture.ext.viewModel
import java.util.concurrent.TimeUnit

class LoaderView: BaseFragment() {
    override val navigationId: String = Views.LOADING_VIEW
    override val layout: Int = R.layout.loading_view

    val viewModel: LoaderViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlideApp.with(this)
                .load(R.drawable.bg)
                .override(640, 640)
                .into(imageView)

        Observable.timer(5, TimeUnit.SECONDS)
                .ui()
                .subscribe({
                    viewModel.forward()
                }, ErrorHandler::handle)
    }

}