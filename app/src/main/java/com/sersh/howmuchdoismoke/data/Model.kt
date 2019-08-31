package com.sersh.howmuchdoismoke.data

import android.util.Log

import com.sersh.howmuchdoismoke.data.local.AppDatabase
import com.sersh.howmuchdoismoke.data.model.Cigarette
import com.sersh.howmuchdoismoke.data.room.RoomApplication
import java.text.SimpleDateFormat
import java.util.*

class Model() {
    var LOG_TAG = "Model"
    private var localDatabase: AppDatabase = RoomApplication.instance!!.db
    private var list = localDatabase.cigaretteDao().all
    private val dateFormat = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
    private val electronic = "electronic"
    private val simple = "simple"
    private var limitSigaret = 20
    private  var sigaretPrice = 28.9

    fun getLimitSigaret():Int
    {
        return limitSigaret
    }
    fun getSigaretPrice():Double
    {
        return sigaretPrice
    }


    fun getlocalDatabase (): AppDatabase
    {
        return localDatabase;
    }


    fun getList (): List<Cigarette>
    {
        return list;
    }

     fun upDate()
    {
        list = localDatabase.cigaretteDao().all
    }


    fun getDataToday(): String {
        val cal = Calendar.getInstance()
        var dataToday = dateFormat.format(cal.getTime()).toString()
        return dataToday
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

    fun getDayOFWeek (int: Int):Int
    { Log.d(LOG_TAG, "getDayOFWeek - $int")
        val c = Calendar.getInstance()
        c.add(Calendar.DATE, int)
        val dayOfWeek = c.get(Calendar.DAY_OF_WEEK)
        return dayOfWeek
    }

}
