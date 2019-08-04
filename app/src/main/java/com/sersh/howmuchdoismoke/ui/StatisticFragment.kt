package com.sersh.howmuchdoismoke.ui

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sersh.howmuchdoismoke.ui.adapter.PageAdapter

import com.sersh.howmuchdoismoke.R





class StatisticFragment : androidx.fragment.app.Fragment() {
    private lateinit var pageAdapter : PageAdapter
    private lateinit var viewPager: androidx.viewpager.widget.ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pageAdapter = PageAdapter(activity!!.getSupportFragmentManager())
        viewPager = view.findViewById(com.sersh.howmuchdoismoke.R.id.pager)
        viewPager.adapter = pageAdapter
        tabLayout = view.findViewById(com.sersh.howmuchdoismoke.R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }


}
