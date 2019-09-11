package com.sersh.howmuchdoismoke.ui.AllTime

import com.sersh.howmuchdoismoke.ui.AllTime.IAllTime
import com.sersh.howmuchdoismoke.ui.Presenter
import com.sersh.howmuchdoismoke.utils.DateMy

class AllTimePresenter (val iAllTime: IAllTime): Presenter() {

    override fun get() {

    }
     fun getAllOnYear(int:Int): List<DateMy> {
        var list: MutableList<DateMy> = arrayListOf()
        val mounOnYear = 12
        for (k in 1..mounOnYear) {

            var res = smokeOnData(
                k,
                model.getData(int).get(0),
                model.getList()
            )
            list.add(DateMy(res, iAllTime.getMount()[k - 1]))
        }
        return list
    }

    fun getYear (int: Int):List<String>
    {
       return model.getData(int)
    }
}