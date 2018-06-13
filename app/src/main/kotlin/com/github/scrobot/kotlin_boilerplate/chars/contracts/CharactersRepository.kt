package com.github.scrobot.kotlin_boilerplate.chars.contracts

import io.reactivex.Observable
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.business.entities.ResponseWrapper

interface CharactersRepository {

    fun getChars(page: Int? = null): Observable<ResponseWrapper<CartoonCharacter>>
    fun getChar(id: Long): Observable<CartoonCharacter>

}