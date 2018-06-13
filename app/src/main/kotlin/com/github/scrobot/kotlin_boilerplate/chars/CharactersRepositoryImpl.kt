package com.github.scrobot.kotlin_boilerplate.chars

import com.github.scrobot.kotlin_boilerplate.chars.contracts.CharactersRepository
import com.github.scrobot.kotlin_boilerplate.global.BackendApi

class CharactersRepositoryImpl(
        private val api: BackendApi
): CharactersRepository {

    override fun getChars(page: Int?) = api.charactersList(page)

    override fun getChar(id: Long) = api.character(id)


}