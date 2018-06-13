package com.github.scrobot.kotlin_boilerplate.presentation.chars

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.github.scrobot.kotlin_boilerplate.business.chars.contracts.CharacterInteractor
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharacter
import com.github.scrobot.kotlin_boilerplate.business.chars.entities.CartoonCharactersHolder
import com.github.scrobot.kotlin_boilerplate.global.ErrorHandler
import com.github.scrobot.kotlin_boilerplate.global.Views
import com.github.scrobot.kotlin_boilerplate.global.extentions.ui
import com.github.scrobot.kotlin_boilerplate.global.viewmodels.RxViewModel
import ru.terrakok.cicerone.Router
import timber.log.Timber

class CharactersViewModel(private val router: Router, private val interactor: CharacterInteractor): RxViewModel() {

    private val charactersLiveData = MutableLiveData<CartoonCharactersHolder>()
    private val characterLiveData = MutableLiveData<CartoonCharacter>()

    fun observeCharactersList(): LiveData<CartoonCharactersHolder> {
        requestCharacters()

        return charactersLiveData
    }

    fun observeCharacter(id: Long): LiveData<CartoonCharacter> {
        interactor.getChar(id)
                .ui()
                .subscribe({
                    characterLiveData.value = it
                }, ErrorHandler::handle)

        return characterLiveData
    }

    fun requestCharacters(page: Int? = null) {
        Timber.d(interactor.toString())
        interactor.getChars(page)
                .ui()
                .subscribe({
                    Timber.d(it.toString())
                    charactersLiveData.value = it
                }, ErrorHandler::handle)
    }

    fun navigateToDetail(url: String?) = router.navigateTo(Views.CHARS_DEATAIL, url)
}