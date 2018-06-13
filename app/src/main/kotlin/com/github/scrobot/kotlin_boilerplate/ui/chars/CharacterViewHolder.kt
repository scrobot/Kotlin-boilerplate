package com.github.scrobot.kotlin_boilerplate.ui.chars

import android.content.Context
import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.scrobot.kotlin_boilerplate.R
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.global.GlideApp
import com.github.scrobot.kotlin_boilerplate.global.extentions.vis
import com.github.scrobot.kotlin_boilerplate.global.ui.adapter.AbstractViewHolder
import kotlinx.android.synthetic.main.character_item.view.*

class CharacterViewHolder(val view: View, val context: Context): AbstractViewHolder<CartoonCharacter>(view, context) {

    override fun bind(holder: CartoonCharacter) {
        with(view) {
            GlideApp.with(this)
                    .load(holder.image)
                    .centerCrop()
                    .placeholder(R.drawable.placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(vImage)

            vName.text = holder.name

            vGender.text = context.getString(R.string.chars_gender).format(holder.gender)
            vSpecies.text = context.getString(R.string.chars_species).format(holder.species)
            vStatus.text = context.getString(R.string.chars_status).format(holder.status)

            listOf(vGender, vSpecies, vStatus).forEach { it.vis { true } }

        }

    }

}