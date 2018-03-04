package com.iceproject.mindthegap.ui

import android.preference.PreferenceManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.iceproject.mindthegap.R
import com.iceproject.mindthegap.model.Language
import java.lang.ref.WeakReference

/**
 * Created by razva on 3/3/2018.
 */
class WordsAdapter(private val status: BooleanArray, private val file: Int, private val section: Int, private val listener: ClickListener) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_word, parent, false), status, file, section, listener)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(layout: View, private val status: BooleanArray, private val file: Int, private val section: Int, listener: ClickListener) : RecyclerView.ViewHolder(layout), View.OnClickListener {

        val txvAnswers: TextView = layout.findViewById(R.id.txvAnswers)
        val txvQuestions: TextView = layout.findViewById(R.id.txvQuestions)
        val imgQuestions: ImageView = layout.findViewById(R.id.imgQuestions)
        val imgAnswers: ImageView = layout.findViewById(R.id.imgAnswers)
        val cbxSelected: CheckBox = layout.findViewById(R.id.cbxSelected)
        val listenerClick = WeakReference<ClickListener>(listener)

        init {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(layout.context)

            imgQuestions.setImageResource(Language.valueOf(sharedPreferences.getString(layout.context.getString(R.string.pref_lang_questions), "")).flag)
            imgAnswers.setImageResource(Language.valueOf(sharedPreferences.getString(layout.context.getString(R.string.pref_lang_answers), "")).flag)
            cbxSelected.setOnClickListener(this)
            layout.setOnClickListener { cbxSelected.callOnClick() }
        }

        override fun onClick(p0: View?) {
            listenerClick.get()?.onPositionClicked(adapterPosition)
        }

    }
}