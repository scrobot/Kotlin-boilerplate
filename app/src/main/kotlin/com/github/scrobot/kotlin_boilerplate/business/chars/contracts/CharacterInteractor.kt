package com.github.scrobot.kotlin_boilerplate.business.chars.contracts

import io.reactivex.Observable
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharactersHolder

interface CharacterInteractor {

    fun getChars(page: Int? = null): Observable<CartoonCharactersHolder>
    fun getChar(id: Long): Observable<CartoonCharacter>

}