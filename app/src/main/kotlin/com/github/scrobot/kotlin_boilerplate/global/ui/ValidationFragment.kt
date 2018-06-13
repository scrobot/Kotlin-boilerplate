package com.github.scrobot.kotlin_boilerplate.global.ui

import android.widget.EditText
import com.github.scrobot.kotlin_boilerplate.global.ui.holders.ValidationHolder

/**
 * Created by alexscrobot on 17.03.18.
 */
abstract class ValidationFragment: BaseFragment() {

    abstract val validationFieldsMap: Map<String, EditText>

    fun checkValidation(holder: ValidationHolder?, block: ValidationFragment.(fails: Boolean, error: String?) -> Unit) {
        val validationFails = holder != null

        if(validationFails) {
//            holder?.fields?.forEach { tag -> getFieldByTag(tag)?.setErrorField() }
        }

        block(validationFails, holder?.error)
    }

    open fun getFieldByTag(tag: String?): EditText? {
        if(validationFieldsMap.isNotEmpty()) {
            return validationFieldsMap[tag]
        }

        return null
    }

}