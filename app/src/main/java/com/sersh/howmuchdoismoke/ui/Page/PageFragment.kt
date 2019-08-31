package com.sersh.howmuchdoismoke.ui.Page


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sersh.howmuchdoismoke.R
import com.sersh.howmuchdoismoke.ui.adapter.RecycleAdapters
import kotlinx.android.synthetic.main.fragment_page.*


class PageFragment(var position: Int) : Fragment(), IPageView {


    private val presenter by lazy { PagePresenter(this) }
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var recycle: RecyclerView
    private lateinit var recycleManeger: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_page, container, false)
        recycle = root.findViewById<RecyclerView>(R.id.recyclelistview)
        recycleManeger = LinearLayoutManager(activity!!)
        adapter = RecycleAdapters(presenter.getAllList(position))
        recycle.adapter = adapter
        recycle.layoutManager = recycleManeger
        return root
    }

    override fun onResume() {
        init()
        overuse()
        super.onResume()
    }


    private fun init() {

        all_sigaret.text = presenter.getAllSiagret(position).get(0).toString()
        similar_sigaret.text = presenter.getAllSiagret(position).get(1).toString()
        electronic_sigaret.text = presenter.getAllSiagret(position).get(2).toString()


    }

    private fun overuse() {
        if (position == 0 && presenter.getAllSiagret(position).get(0) > 20) {
            var string = presenter.getAllSiagret(position).get(0).toString() + "→" + presenter.getLimit()
            all_sigaret.setTextColor(resources.getColor(R.color.colorAccent))
            all_sigaret.text = string
        }
    }

    override fun getWeek(): String {
        return resources.getString(R.string.week_l)
    }

    override fun getMount(): Array<String> {
        var array: Array<String> = arrayOf(
            resources.getString(R.string.january),
            resources.getString(R.string.february),
            resources.getString(R.string.march),
            resources.getString(R.string.april),
            resources.getString(R.string.may),
            resources.getString(R.string.june),
            resources.getString(R.string.july),
            resources.getString(R.string.august),
            resources.getString(R.string.september),
            resources.getString(R.string.october),
            resources.getString(R.string.november),
            resources.getString(R.string.december)
        )
        return array
    }

    override fun getDay(int: Int):  String? {
        var map: MutableMap<Int,String> = HashMap<Int,String>()
        map.put(1,resources.getString(R.string.sanday) )
        map.put(2,resources.getString(R.string.monday) )
        map.put(3,resources.getString(R.string.tuesday) )
        map.put(4,resources.getString(R.string.wednesday) )
        map.put(5,resources.getString(R.string.thursday) )
        map.put(6,resources.getString(R.string.friday) )
        map.put(7,resources.getString(R.string.saturday) )

return map.get(int)
    }
}
