package com.sersh.howmuchdoismoke.ui.adapter

import com.sersh.howmuchdoismoke.ui.Page.PageFragment


class PageAdapter (fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm){
    private  val ARG_OBJECT = "object"
    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        return PageFragment(p0)
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