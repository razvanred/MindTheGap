package com.iceproject.mindthegap.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.iceproject.mindthegap.R

/**
 * Created by razvanrosu on 26/02/2018.
 */
class FilesAdapter(val status: BooleanArray = arrayOf(false).toBooleanArray()) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_file, parent, false))

    override fun getItemCount() = 24

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.layout?.findViewById<TextView>(R.id.checkBox)?.text = holder?.layout?.context?.getString(R.string.file_d, position + 1)
        val btnEdit = holder?.layout?.findViewById<Button>(R.id.btnEdit)
        //btnEdit?.tag=position+1
        holder?.layout?.findViewById<CheckBox>(R.id.checkBoxFile)?.setOnClickListener { view ->
            if ((view as CheckBox).isSelected)
                btnEdit?.isEnabled = true
        }
        btnEdit?.setOnClickListener { view ->
            run {
            }
        }
    }

}