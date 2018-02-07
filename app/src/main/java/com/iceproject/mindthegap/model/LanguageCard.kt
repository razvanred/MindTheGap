package com.iceproject.mindthegap.model

import android.view.View

/**
 * Created by razvanrosu on 07/02/2018.
 */
class LanguageCard(card: View, language: Language) {

    init {
        language.setLanguage(card)
    }

}