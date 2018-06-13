package com.github.scrobot.kotlin_boilerplate.business.chars

import com.github.scrobot.kotlin_boilerplate.business.chars.contracts.CharacterInteractor
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharactersHolder
import com.github.scrobot.kotlin_boilerplate.business.entities.ResponseWrapper
import com.github.scrobot.kotlin_boilerplate.chars.contracts.CharactersRepository
import io.reactivex.Observable

class CharsIntercatorImpl(private val repository: CharactersRepository): CharacterInteractor {

    override fun getChars(page: Int?) = repository.getChars(page)
            .map(::convertRepostoseToHolder)

    override fun getChar(id: Long): Observable<CartoonCharacter> = repository.getChar(id)

    private fun convertRepostoseToHolder(response: ResponseWrapper<CartoonCharacter>) = CartoonCharactersHolder(
            response.results ?: listOf(),
            response.info?.pages ?: 0 > 1,
            response.info?.next
    )

}