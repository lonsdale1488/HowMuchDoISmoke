package com.sersh.howmuchdoismoke.ui


import android.util.Log
import com.sersh.howmuchdoismoke.data.room.CigaretteEntity

import java.text.SimpleDateFormat
import java.util.*


class InformationPresenter(var iInfirmationView: IInfirmationView) {

    var infirmationModel = InfirmationModel(this)

   var LOG_TAG = "InformationPresenter"
   val dateFormat = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
   val cal = Calendar.getInstance()


   fun addCigaret()
   {
       //Log.d(LOG_TAG,"work addCigaret()")
     // Log.d(LOG_TAG,dateFormat.format(cal.getTime()).toString())
 //      infirmationModel.localDatabase.cigaretteDao().insert(CigaretteEntity(1,"",infirmationModel.getDataToday()))
     // Log.d(LOG_TAG,"start  setCigaret()")
       infirmationModel.list = infirmationModel.localDatabase.cigaretteDao().all
   //   setCigaret()
   }

//   fun setCigaret()
//   {
//       var dayToday= infirmationModel.getDataToday(true).get(2)
//       var monthToday= infirmationModel.getDataToday(true).get(1)
//       var yearToday= infirmationModel.getDataToday(true).get(0)
//      iInfirmationView.setCigaret(somoukeOnData(dayToday,monthToday, yearToday, infirmationModel.list ))
//   }


//    fun smokeYestordsy ()
//    {
//
//        var dayYesterday= infirmationModel.getDataYesterday(true).get(2)
//        var monthYesterday= infirmationModel.getDataYesterday(true).get(1)
//        var yearYesterday= infirmationModel.getDataYesterday(true).get(0)
//
//        Log.d(LOG_TAG,"yestorday" + infirmationModel.getDataYesterday() )
//
//       iInfirmationView.setCigaretYestorday(somoukeOnData(dayYesterday,monthYesterday, yearYesterday, infirmationModel.list ))
//  }

//    fun somoukeAverage ()
//    {
//        var result = 0
//
//  for (i in -8..-1 step 1)
//  {
//
//      var days= infirmationModel.getData(i).get(2)
//      var month= infirmationModel.getData(i).get(1)
//      var year= infirmationModel.getData(i).get(0)
//      var res = somoukeOnData(days, month, year, infirmationModel.list)
//      Log.d(LOG_TAG,"res = $res" )
//      result += res
//        }
//        iInfirmationView.setCigaretAverage(result/7)
//    }
//    fun somoukeOnData (day:String, month:String, year:String, list:List<CigaretteEntity>):Int
//    {
//
//        var variable = 0
//        for (i in 0..list.size-1)
//        {
//          //  val char2= list.get(i).data
//            var array1 = char2.split(".")
//            Log.d(LOG_TAG,"data $array1[2] $array1[1] $array1[0]")
//            if (day.equals(array1[2]) && month.equals(array1[1]) &&  year.equals(array1[0]) )
//            {
//                variable +=1
//            }
//        }
//        return variable
//
//    }







}
