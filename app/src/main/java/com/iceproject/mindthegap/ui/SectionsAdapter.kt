package com.iceproject.mindthegap.ui

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.buildware.widget.indeterm.IndeterminateCheckBox
import com.iceproject.mindthegap.R

/**
 * Created by razva on 3/3/2018.
 */
class SectionsAdapter(private val status: BooleanArray, private val file: Int) : RecyclerView.Adapter<SectionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_section, parent, false))
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(private val layout: View) : RecyclerView.ViewHolder(layout) {
        val txvName: TextView = layout.findViewById(R.id.txvName)
        val cbxSelected: IndeterminateCheckBox = layout.findViewById(R.id.cbxSelected)
        val recycler: RecyclerView = layout.findViewById(R.id.recycler)

        init {
            recycler.setHasFixedSize(true)
            recycler.layoutManager = LinearLayoutManager(recycler.context)
            recycler
        }
    }

}