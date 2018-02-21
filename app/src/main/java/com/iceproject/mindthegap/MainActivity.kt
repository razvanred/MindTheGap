package com.iceproject.mindthegap

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.iceproject.mindthegap.model.Language
import com.iceproject.mindthegap.model.LanguageCard
import com.xw.repo.BubbleSeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var arrayCard: Array<LanguageCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        txvWords.text = resources.getQuantityString(R.plurals.d_word, 0, 0)

        arrayCard = arrayOf(LanguageCard(cardQuestions, Language.IT), LanguageCard(cardAnswers, Language.EN))

        inclContent.viewTreeObserver.addOnScrollChangedListener { bsbWordsNumber.correctOffsetWhenContainerOnScrolling() }

        bsbWordsNumber.onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {

            override fun getProgressOnFinally(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {}

            override fun getProgressOnActionUp(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {
                txvWords.text = resources.getQuantityString(R.plurals.d_word, progress, progress)
            }

            override fun onProgressChanged(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {}

        }

        btnPlus.setOnClickListener { }
        btnMinus.setOnClickListener { bsbWordsNumber.setProgress(bsbWordsNumber.progressFloat - 1) }


        cardQuestions.tag = arrayCard[0]
        cardAnswers.tag = arrayCard[1]

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.actSettings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun changeLanguage(view: View) {

        val card = view.tag as LanguageCard

        card.changeLanguage(if (view.tag.toString().toInt() == R.id.cardQuestions) cardAnswers else cardQuestions)

    }

    fun setNumber(view: View) {

    }
}
