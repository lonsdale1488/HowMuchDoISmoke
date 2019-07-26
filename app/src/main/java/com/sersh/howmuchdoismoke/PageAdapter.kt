package com.sersh.howmuchdoismoke

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter




class PageAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){
    private  val ARG_OBJECT = "object"
    override fun getItem(p0: Int): Fragment {
        val fragment = Fragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putString(ARG_OBJECT, "Fagment" + p0 + 1)
        }
        return fragment
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence {
        return "Fragment ${(position + 1)}"
    }
}