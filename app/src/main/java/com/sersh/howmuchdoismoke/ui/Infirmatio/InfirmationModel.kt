package com.sersh.howmuchdoismoke.ui.Infirmatio

import android.util.Log

import com.sersh.howmuchdoismoke.data.local.AppDatabase
import com.sersh.howmuchdoismoke.data.room.RoomApplication
import java.text.SimpleDateFormat
import java.util.*

class InfirmationModel(var infirmationPresenter: InformationPresenter) {
    var LOG_TAG = "InfirmationModel"
    var localDatabase: AppDatabase = RoomApplication.instance!!.db
    var list = localDatabase.cigaretteDao().all
    val dateFormat = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
    val electronic = "electronic"
    val simple = "simple"
    var limitSigaret = 20

    fun getDataToday(): String {
        val cal = Calendar.getInstance()
        var dataToday = dateFormat.format(cal.getTime()).toString()
        return dataToday
    }

    fun getDataToday(listFormat: Boolean): List<String> {
        val cal = Calendar.getInstance()
        var dataToday = dateFormat.format(cal.getTime()).toString().split(".")
        return dataToday
    }

    fun getDataYesterday(listFormat: Boolean): List<String> {
        val call = Calendar.getInstance()
        call.add(Calendar.DATE, -1)
        val DataYestorday = dateFormat.format(call.time).toString().split(".")
        return DataYestorday
    }

    fun getData(int: Int): List<String> {
        val call = Calendar.getInstance()
        call.add(Calendar.DATE, int)
        val data = dateFormat.format(call.getTime()).toString().split(".")
        Log.d(LOG_TAG, "getData - $data")
        return data
    }

    fun getType(boolean: Boolean): String {

        if (boolean) {
            Log.d(LOG_TAG, "$simple")
            return simple
        } else {
            Log.d(LOG_TAG, "$electronic")
            return electronic
        }
    }


}
