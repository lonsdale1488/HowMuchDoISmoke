package com.sersh.howmuchdoismoke.ui


import android.provider.ContactsContract
import androidx.constraintlayout.solver.LinearSystem
import android.util.Log
import com.sersh.howmuchdoismoke.DateMy
import com.sersh.howmuchdoismoke.data.room.Cigarette

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


class InformationPresenter(var iInfirmationView: IInfirmationView) {

    var infirmationModel = InfirmationModel(this)

   var LOG_TAG = "InformationPresenter"
   val dateFormat = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
   val cal = Calendar.getInstance()


   fun addCigaret()
   {
       Log.d(LOG_TAG,"work addCigaret()")

      infirmationModel.localDatabase.cigaretteDao().insert(Cigarette(1,"",infirmationModel.getDataToday()))
        Log.d(LOG_TAG,"start  setCigaret()")
       infirmationModel.list = infirmationModel.localDatabase.cigaretteDao().all
     setCigaret()
   }

   fun setCigaret()
   {
       var dayToday= infirmationModel.getDataToday(true).get(2)
       var monthToday= infirmationModel.getDataToday(true).get(1)
       var yearToday= infirmationModel.getDataToday(true).get(0)
      iInfirmationView.setCigaret(somoukeOnData(dayToday,monthToday, yearToday, infirmationModel.list ))
   }


    fun smokeYestordsy ()
    {

        Log.d(LOG_TAG,"yestorday" + infirmationModel.getDataYesterday() )

       iInfirmationView.setCigaretYestorday(
           somoukeOnData(infirmationModel.getDataYesterday(true).get(2),
               infirmationModel.getDataYesterday(true).get(1),
               infirmationModel.getDataYesterday(true).get(0),
               infirmationModel.list ))
  }

    fun somoukeAverage ()
    {
        var result = 0

  for (i in -8..-1 step 1)
  {
      var res = somoukeOnData(
          infirmationModel.getData(i).get(2),
          infirmationModel.getData(i).get(1),
          infirmationModel.getData(i).get(0),
          infirmationModel.list)
      Log.d(LOG_TAG,"res = $res" )
      result += res
        }
        iInfirmationView.setCigaretAverage(result/7)
    }

    fun somoukeOnData (day:String, month:String, year:String, list:List<Cigarette>):Int
    {

        var variable = 0
        for (i in 0..list.size-1)
        {
            val char2= list.get(i).datas
            var array1 = char2.split(".")
            Log.d(LOG_TAG,"data $array1[2] $array1[1] $array1[0]")
            if (day.equals(array1[2]) && month.equals(array1[1]) &&  year.equals(array1[0]) )
            {
                variable +=1
            }
        }
        return variable

    }

 fun smoukeGraf ()
 {
    var list: MutableList<DateMy>  = mutableListOf()
     for (i in -8..-1 step 1)
     {
         somoukeOnData(
             infirmationModel.getData(i).get(2),
             infirmationModel.getData(i).get(1),
             infirmationModel.getData(i).get(0),
             infirmationModel.list)
       var data =  DateMy(somoukeOnData(
             infirmationModel.getData(i).get(2),
             infirmationModel.getData(i).get(1),
             infirmationModel.getData(i).get(0),
             infirmationModel.list)
         , infirmationModel.getData(i).get(2)+ "." + infirmationModel.getData(i).get(1))

         list.add(data)
     }
     iInfirmationView.Chart(list)
 }





}
