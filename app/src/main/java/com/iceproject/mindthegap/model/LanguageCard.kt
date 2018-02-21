package com.iceproject.mindthegap.model

import android.app.AlertDialog
import android.view.View
import com.iceproject.mindthegap.R

/**
 * Created by razvanrosu on 07/02/2018.
 */
class LanguageCard(card: View, val language: Language) {

    init {
        language.setLanguage(card)
    }

    fun changeLanguage(other: View) {
        AlertDialog.Builder(other.context, android.R.style.Theme_Material_Dialog_Alert)
                .setTitle(other.context.resources.getQuantityString(R.plurals.answer, 1))
                .show()
    }

}