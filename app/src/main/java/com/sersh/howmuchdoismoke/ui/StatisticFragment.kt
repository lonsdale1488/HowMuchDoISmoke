package com.sersh.howmuchdoismoke.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sersh.howmuchdoismoke.PageAdapter

import com.sersh.howmuchdoismoke.R


class StatisticFragment : androidx.fragment.app.Fragment() {


    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var pageAdapter : PageAdapter
    private lateinit var viewPager: androidx.viewpager.widget.ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pageAdapter = PageAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = pageAdapter
        tabLayout = view.findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)

    }
}
