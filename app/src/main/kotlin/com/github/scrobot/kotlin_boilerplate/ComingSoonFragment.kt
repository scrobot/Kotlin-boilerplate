package com.github.scrobot.kotlin_boilerplate

import android.os.Bundle
import android.view.View
import com.github.scrobot.kotlin_boilerplate.global.GlideApp
import com.github.scrobot.kotlin_boilerplate.global.ui.BottomBarFragment
import kotlinx.android.synthetic.main.comming_soon.*

class ComingSoonFragment: BottomBarFragment() {
    override val layout = R.layout.comming_soon
    override val navigationId = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlideApp.with(this)
                .load(R.drawable.coming_soon)
                .override(600, 600)
                .into(imageView2)

    }
}