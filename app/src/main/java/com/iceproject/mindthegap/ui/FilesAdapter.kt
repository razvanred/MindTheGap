package com.iceproject.mindthegap.ui

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.buildware.widget.indeterm.IndeterminateCheckBox
import com.iceproject.mindthegap.R
import java.lang.ref.WeakReference

/**
 * Created by razvanrosu on 26/02/2018.
 */
class FilesAdapter(private val listener: ClickListener, private val status: Array<Boolean?>) : RecyclerView.Adapter<FilesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        Log.d(FilesAdapter::class.java.simpleName, "CREATING")

        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_file, parent, false), listener, status)
    }

    override fun getItemCount() = 24

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        Log.d(FilesAdapter::class.java.simpleName, "BINDING $position")

        //Bind view and data
        holder?.checkBox?.text = holder?.checkBox?.context?.getString(R.string.file_d, position + 1)
        holder?.checkBox?.state = status[position]
        holder?.button?.isEnabled = status[position] == null || status[position]!!
    }

    class ViewHolder(layout: View, listener: ClickListener, private val status: Array<Boolean?>) : RecyclerView.ViewHolder(layout), View.OnClickListener {

        val checkBox: IndeterminateCheckBox = layout.findViewById(R.id.checkBoxFile)
        val button: Button = layout.findViewById(R.id.btnEdit)
        private val listenerRef = WeakReference<ClickListener>(listener)

        init {
            //layout.setOnClickListener(this)
            checkBox.setOnClickListener(this)
            button.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            if (p0?.id == checkBox.id) {
                button.isEnabled = (p0 as IndeterminateCheckBox).isChecked
                status[adapterPosition] = button.isEnabled
            } else
                listenerRef.get()?.onPositionClicked(adapterPosition)
        }

    }
}