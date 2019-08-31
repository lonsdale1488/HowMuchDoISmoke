package com.sersh.howmuchdoismoke.ui.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sersh.howmuchdoismoke.R
import com.sersh.howmuchdoismoke.utils.DateMy

class RecycleAdapters (val list: List<DateMy>): RecyclerView.Adapter<RecycleAdapters.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: RecycleAdapters.MyViewHolder, position: Int) {

        holder.one!!.text = list.get(position).data
            holder.two!!.text = list.get(position).number.toString()
        if (holder.two!!.text.equals("0"))
        {
            holder.two!!.setTypeface(Typeface.DEFAULT)
        }



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