package com.iceproject.mindthegap.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.iceproject.mindthegap.R

/**
 * Created by razvanrosu on 26/02/2018.
 */
class FilesAdapter : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_file, parent, false))

    override fun getItemCount() = 24

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.layout?.findViewById<TextView>(R.id.checkBox)?.text = holder?.layout?.context?.getString(R.string.file_d, position + 1)
    }

}