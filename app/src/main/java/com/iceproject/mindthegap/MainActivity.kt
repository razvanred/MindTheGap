package com.iceproject.mindthegap

import android.content.Intent
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
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var arrayCard: Array<LanguageCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        txvWords.text = resources.getQuantityString(R.plurals.d_word, 0, 0)
        txvFiles.text = resources.getQuantityString(R.plurals.d_selected, 0, 0)

        arrayCard = arrayOf(LanguageCard(cardQuestions, Language.IT), LanguageCard(cardAnswers, Language.EN))

        inclContent.viewTreeObserver.addOnScrollChangedListener { bsbWordsNumber.correctOffsetWhenContainerOnScrolling() }

        bsbWordsNumber.onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {

            override fun getProgressOnFinally(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {
                txvWords.text = resources.getQuantityString(R.plurals.d_word, progress, progress)
            }

            override fun getProgressOnActionUp(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {
                txvWords.text = resources.getQuantityString(R.plurals.d_word, progress, progress)
            }

            override fun onProgressChanged(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {
                if (progress == bsbWordsNumber.min.roundToInt()) {
                    fab.hide()
                    btnMinus.isEnabled = false
                } else {
                    fab.show()
                    btnMinus.isEnabled = true
                    btnPlus.isEnabled = progress != bsbWordsNumber.max.roundToInt()
                }
            }

        }

        btnPlus.setOnClickListener {
            bsbWordsNumber.setProgress((bsbWordsNumber.progress + 1).toFloat())
        }
        btnMinus.setOnClickListener {
            bsbWordsNumber.setProgress((bsbWordsNumber.progress - 1).toFloat())
        }

        cardQuestions.tag = arrayCard[0]
        cardAnswers.tag = arrayCard[1]

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actSettings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun changeLanguage(view: View) {

        val card = view.tag as LanguageCard

        card.changeLanguage(if (view.tag.toString().toInt() == R.id.cardQuestions) cardAnswers else cardQuestions)

    }

    fun setFiles(view: View) {
        startActivityForResult(Intent(this, SelectFilesActivity::class.java), 0)
    }
}
