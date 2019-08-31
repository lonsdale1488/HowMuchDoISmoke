package com.sersh.howmuchdoismoke.ui

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.sersh.howmuchdoismoke.ui.adapter.PageAdapter
import android.view.*
import com.sersh.howmuchdoismoke.MainActivity
import kotlinx.android.synthetic.main.fragment_statistic.*


class StatisticFragment : androidx.fragment.app.Fragment() {
    private lateinit var pageAdapter : PageAdapter
    private lateinit var viewPager: androidx.viewpager.widget.ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(com.sersh.howmuchdoismoke.R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pageAdapter = PageAdapter(activity!!.getSupportFragmentManager())
        viewPager = view.findViewById(com.sersh.howmuchdoismoke.R.id.pager)
        viewPager.adapter = pageAdapter
        tabLayout = view.findViewById(com.sersh.howmuchdoismoke.R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        super.onResume()
        initListener ()
    }
    fun initListener ()
    {
        back.setOnClickListener {
            (activity as MainActivity).showInformationFragment()
        }
    }
}
