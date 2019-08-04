package com.sersh.howmuchdoismoke.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sersh.howmuchdoismoke.R

class RecycleAdapters (val list: List<String>): RecyclerView.Adapter<RecycleAdapters.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: RecycleAdapters.MyViewHolder, position: Int) {
        holder.one!!.text = list[position]
            holder.two!!.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var one:TextView? = null
        var two:TextView? = null
        init {
            one = itemView.findViewById(R.id.first_textrecycle)
            two = itemView.findViewById(R.id.last_textrecycle)
        }

    }
}