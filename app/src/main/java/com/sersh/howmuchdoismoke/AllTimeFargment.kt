package com.sersh.howmuchdoismoke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sersh.howmuchdoismoke.ui.adapter.RecycleAdapters
import kotlinx.android.synthetic.main.fragment_all_time.*

class AllTimeFargment() : Fragment(), IAllTime {
    val presenter= AllTimePresenter(this)
    lateinit var recyclAdapter: RecyclerView.Adapter<*>
    lateinit var recycleMeneger: RecyclerView.LayoutManager
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var root = inflater.inflate(R.layout.fragment_all_time, container, false)

        innit(root, 0, R.id.recycle_one)
        innit(root, -365, R.id.recycle_two)
        return root
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

    override fun onResume() {
        last_year.text = presenter.getYear(-365).get(0).toString()
        year.text = presenter.getYear(0).get(0).toString()
        super.onResume()
    }


    fun innit(root: View, int: Int, int2: Int) {
        recyclerView = root.findViewById(int2)
        recyclAdapter = RecycleAdapters(presenter.getAllOnYear(int))
        recycleMeneger = LinearLayoutManager(activity!!)
        recyclerView.layoutManager = recycleMeneger
        recyclerView.adapter = recyclAdapter
    }
}