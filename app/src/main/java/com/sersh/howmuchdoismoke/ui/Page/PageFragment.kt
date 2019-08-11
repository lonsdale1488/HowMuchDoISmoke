package com.sersh.howmuchdoismoke.ui.Page


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sersh.howmuchdoismoke.R
import com.sersh.howmuchdoismoke.ui.Infirmatio.InformationPresenter
import com.sersh.howmuchdoismoke.ui.adapter.RecycleAdapters
import kotlinx.android.synthetic.main.fragment_day.*


class PageFragment (var position:Int)  : Fragment(), PageView  {
    private val presenter by lazy { PagePresenter(this) }
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var recycle: RecyclerView
    private lateinit var recycleManeger: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_day, container, false)
        recycle = root.findViewById<RecyclerView>(R.id.recyclelistview)
        recycleManeger = LinearLayoutManager(activity)
        adapter = RecycleAdapters(presenter.getAllList(position))
        recycle.adapter = adapter
        recycle.layoutManager = recycleManeger
        return root
    }

    override fun onResume() {
        init()
        super.onResume()
    }


    fun init ()
    {
        all_sigaret.text = presenter.getAllSiagret(position).get(0).toString()
        similar_sigaret.text = presenter.getAllSiagret(position).get(1).toString()
        electronic_sigaret.text = presenter.getAllSiagret(position).get(2).toString()

    }


}
