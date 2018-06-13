package com.github.scrobot.kotlin_boilerplate.ui.chars

import android.view.ViewGroup
import com.github.scrobot.kotlin_boilerplate.R
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.global.extentions.inflate
import com.github.scrobot.kotlin_boilerplate.global.ui.adapter.DelegateAdapter

class CharactersAdapter: DelegateAdapter<CartoonCharacter, CharacterViewHolder>(R.layout.character_item) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=  CharacterViewHolder(parent.inflate(layout), parent.context)

}