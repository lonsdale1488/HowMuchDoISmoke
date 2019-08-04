package com.sersh.howmuchdoismoke.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sersh.howmuchdoismoke.R
import com.sersh.howmuchdoismoke.ui.adapter.RecycleAdapters
import kotlinx.android.synthetic.main.fragment_day.*


class PageFragment  : Fragment() {

    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var recycle: RecyclerView
    private lateinit var recycleManeger: RecyclerView.LayoutManager
    var  list: List<String> = listOf("1","2","3","4","5","6","7","8","9","10")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_day, container, false)
        recycle = root.findViewById<RecyclerView>(R.id.recyclelistview)
        recycleManeger = LinearLayoutManager(activity)
        adapter = RecycleAdapters(list)
        recycle.adapter = adapter
        recycle.layoutManager = recycleManeger
        return root
    }

    override fun onResume() {
     //  init()
        super.onResume()
    }


    fun init ()
    {

        all_sigaret.text = ""
        similar_sigaret.text = ""
        electronic_sigaret.text = ""
    }


}
