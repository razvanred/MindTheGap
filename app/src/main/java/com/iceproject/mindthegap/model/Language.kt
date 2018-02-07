package com.iceproject.mindthegap.model

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.iceproject.mindthegap.R

/**
 * Created by razvanrosu on 02/02/2018.
 */
enum class Language(@StringRes val title: Int, @DrawableRes val flag: Int) {
    IT(R.string.italian, R.drawable.flag_it),
    EN(R.string.english, R.drawable.flag_uk);

    fun setLanguage(view: View) {
        view.findViewById<Button>(R.id.btnLanguage).setText(title)
        view.findViewById<ImageView>(R.id.imgCountry).setImageResource(flag)
    }
}