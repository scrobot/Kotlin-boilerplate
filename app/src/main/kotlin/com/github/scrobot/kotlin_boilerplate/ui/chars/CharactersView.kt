package com.github.scrobot.kotlin_boilerplate.ui.chars

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.scrobot.kotlin_boilerplate.R
import com.github.scrobot.kotlin_boilerplate.global.SpringAnimationUtils
import com.github.scrobot.kotlin_boilerplate.global.Views
import com.github.scrobot.kotlin_boilerplate.global.extentions.vis
import com.github.scrobot.kotlin_boilerplate.global.ui.BottomBarFragment
import com.github.scrobot.kotlin_boilerplate.global.ui.ItemClickSupport
import com.github.scrobot.kotlin_boilerplate.presentation.chars.CharactersViewModel
import kotlinx.android.synthetic.main.chars_view.*
import org.koin.android.architecture.ext.viewModel
import timber.log.Timber

class CharactersView: BottomBarFragment() {

    override val layout: Int = R.layout.chars_view
    override val navigationId: String = Views.CHARS

    val adapter = CharactersAdapter()
    val viewModel: CharactersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d(viewModel.toString())

        vCharsList.layoutManager = LinearLayoutManager(context)
        vCharsList.adapter = adapter

        viewModel.observeCharactersList()
                .observe(this, Observer {
                    Timber.d(it.toString())
                    adapter.load(it?.cartoonCharacter).also { vProgressBar.vis { false } }
                })

        ItemClickSupport.addTo(vCharsList).setOnItemClickListener { _, position, v ->
            SpringAnimationUtils.setSpringAnimation(v)

//            val item = adapter.getItemByPosition(position)
//            viewModel.navigateToDetail(item?.url)
        }
    }

}