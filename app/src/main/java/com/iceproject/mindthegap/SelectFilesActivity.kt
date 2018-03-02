package com.iceproject.mindthegap

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.iceproject.mindthegap.ui.ClickListener
import com.iceproject.mindthegap.ui.FilesAdapter
import kotlinx.android.synthetic.main.activity_select_files.*

class SelectFilesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_files)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        val booleanArray = arrayOfNulls<Boolean>(24)

        for (i in 0 until booleanArray.size)
            booleanArray[i] = false


        recycler.adapter = FilesAdapter(object : ClickListener {
            override fun onPositionClicked(position: Int) {

            }
        }, booleanArray)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_select_files, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.actDone -> {
                val toReturn = Intent()
                val booleanArray = BooleanArray((recycler.adapter as FilesAdapter).itemCount)

                for (i in 0 until booleanArray.size)
                    booleanArray[i] = false

                setResult(Activity.RESULT_OK, toReturn)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
