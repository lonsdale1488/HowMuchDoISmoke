package com.sersh.howmuchdoismoke

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter




class PageAdapter (fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm){
    private  val ARG_OBJECT = "object"
    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        val fragment = androidx.fragment.app.Fragment()
        fragment.arguments = Bundle().apply {


            putString(ARG_OBJECT, "Fagment" + p0 + 1)
        }

        return fragment
    }


    override fun getCount(): Int = 5

    override fun getPageTitle(position: Int): CharSequence {
        when(position)
        {
            0->return "День"
            1->return "Тиждень"
            2->return "Місяць"
            3->return "Рік"
            4->return "Весь час "
        }
        return "Fragment ${(position + 1)}"
    }
}