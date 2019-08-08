package com.sersh.howmuchdoismoke.ui.Page

import android.util.Log
import com.sersh.howmuchdoismoke.data.local.AppDatabase
import com.sersh.howmuchdoismoke.data.room.RoomApplication
import java.text.SimpleDateFormat
import java.util.*

class PageModel (var pagePresenter:PagePresenter) {


    var LOG_TAG = "PageModel"
    var localDatabase: AppDatabase = RoomApplication.instance!!.db
    var list = localDatabase.cigaretteDao().all
    val dateFormat = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")

    fun getData(int: Int): List<String> {
        val call = Calendar.getInstance()
        call.add(Calendar.DATE, int)
        val data = dateFormat.format(call.getTime()).toString().split(".")
        Log.d(LOG_TAG, "getData - $data")
        return data
    }

}