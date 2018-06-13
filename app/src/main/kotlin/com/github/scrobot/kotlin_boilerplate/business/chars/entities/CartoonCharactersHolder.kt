package com.github.scrobot.kotlin_boilerplate.business.chars.entities

data class CartoonCharactersHolder(val cartoonCharacter: List<CartoonCharacter> = listOf(), val hasNext: Boolean = false, val next: String? = null)