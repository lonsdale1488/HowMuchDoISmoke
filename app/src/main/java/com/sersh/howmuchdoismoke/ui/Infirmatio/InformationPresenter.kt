package com.sersh.howmuchdoismoke.ui.Infirmatio


import android.util.Log
import com.sersh.howmuchdoismoke.utils.DateMy
import com.sersh.howmuchdoismoke.data.model.Cigarette



class InformationPresenter(var iInfirmationView: IInfirmationView) {

 private var infirmationModel = InfirmationModel(this)

    var LOG_TAG = "InformationPresenter"

    fun addCigaret() {
        Log.d(LOG_TAG, "work addCigaret()")

        infirmationModel.localDatabase.cigaretteDao().insert(
            Cigarette(
                1,
                "Complement",
                infirmationModel.getDataToday(),
                typeCigaret(iInfirmationView.setType()),
                29.5
            )
        )
        Log.d(LOG_TAG, "start  setCigaret()")
        infirmationModel.list = infirmationModel.localDatabase.cigaretteDao().all
        setCigaret()
    }

   private fun typeCigaret (boolean: Boolean):String {
        if (boolean) {
            return infirmationModel.getType(boolean)
        } else {
            return infirmationModel.getType(boolean)
        }

    }

    fun setCigaret() {
        val number = smokeOnData(infirmationModel.getDataToday(true).get(2)
            , infirmationModel.getDataToday(true).get(1)
            , infirmationModel.getDataToday(true).get(0)
            ,  infirmationModel.list)
        if (number > infirmationModel.limitSigaret)
        {
            iInfirmationView.overUse()
        }
        iInfirmationView.setCigaret(number)
    }


    fun smokeYestordsy() {
        iInfirmationView.setCigaretYestorday(
            smokeOnData(
                infirmationModel.getDataYesterday(true).get(2),
                infirmationModel.getDataYesterday(true).get(1),
                infirmationModel.getDataYesterday(true).get(0),
                infirmationModel.list
            )
        )
    }

    fun smokeAverage() {
        var result = 0
        for (i in -8..-1 step 1) {
            var res = smokeOnData(
                infirmationModel.getData(i).get(2),
                infirmationModel.getData(i).get(1),
                infirmationModel.getData(i).get(0),
                infirmationModel.list
            )
            Log.d(LOG_TAG, "res = $res")
            result += res
        }
        iInfirmationView.setCigaretAverage(result / 7)
    }

    fun smokeOnData(day: String, month: String, year: String, list: List<Cigarette>): Int {
        var variable = 0
        for (i in 0..list.size - 1) {
          //  val char2 = list.get(i).datas
            var array1 = list.get(i).datas.split(".")
            Log.d(LOG_TAG, "data $array1[2] $array1[1] $array1[0]")
            if (day.equals(array1[2]) && month.equals(array1[1]) && year.equals(array1[0])) {
                variable += 1
            }
        }
        return variable

    }

    fun smoukeGraf() {
        var list: MutableList<DateMy> = mutableListOf()
        for (i in -8..-1 step 1) {
            smokeOnData(
                infirmationModel.getData(i).get(2),
                infirmationModel.getData(i).get(1),
                infirmationModel.getData(i).get(0),
                infirmationModel.list
            )
            var data = DateMy(
                smokeOnData(
                    infirmationModel.getData(i).get(2),
                    infirmationModel.getData(i).get(1),
                    infirmationModel.getData(i).get(0),
                    infirmationModel.list
                )
                , infirmationModel.getData(i).get(2) + "." + infirmationModel.getData(i).get(1)
            )

            list.add(data)
        }
        iInfirmationView.Chart(list)
    }


}
