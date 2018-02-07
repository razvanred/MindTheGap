package com.iceproject.mindthegap

import android.app.AlertDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.iceproject.mindthegap.model.Language
import com.iceproject.mindthegap.model.LanguageCard
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var langAnswers: Language
    private lateinit var langQuestions: Language
    private lateinit var arrayCard: Array<LanguageCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        arrayCard = arrayOf(LanguageCard(cardQuestions,Language.IT), LanguageCard(cardAnswers,Language.EN))


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

    fun changeLanguage(view:View){
        AlertDialog.Builder(this,android.R.style.Theme_Material_Dialog_Alert)
                .setCancelable(false)
                .show()
    }

    fun setNumber(view: View) {

    }
}
