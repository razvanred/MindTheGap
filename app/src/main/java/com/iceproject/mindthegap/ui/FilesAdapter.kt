package com.iceproject.mindthegap.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import com.iceproject.mindthegap.R

/**
 * Created by razvanrosu on 26/02/2018.
 */
class FilesAdapter : RecyclerView.Adapter<ViewHolder> {

    private val status: BooleanArray

    constructor() {
        status = BooleanArray(24)
    }

    constructor(status: BooleanArray) {
        this.status = status
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_file, parent, false))

    override fun getItemCount() = 24

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val checkBox = holder?.layout?.findViewById<CheckBox>(R.id.checkBoxFile)
        checkBox?.text = holder?.layout?.context?.getString(R.string.file_d, position + 1)
        val btnEdit = holder?.layout?.findViewById<Button>(R.id.btnEdit)
        //btnEdit?.tag=position+1
        if (status != null) {
            checkBox?.isChecked = status[position + 1]
        } else checkBox?.isChecked = false

        checkBox?.setOnClickListener { view ->
            btnEdit?.isEnabled = (view as CheckBox).isChecked
        }
        btnEdit?.setOnClickListener { view ->
            run {

            }
        }
    }

}