package com.sersh.howmuchdoismoke.ui.Infirmatio

import android.util.Log
import com.sersh.howmuchdoismoke.utils.DateMy
import com.sersh.howmuchdoismoke.data.model.Cigarette
import com.sersh.howmuchdoismoke.data.Model

class InformationPresenter(var iInfirmationView: IInfirmationView) {

 private var infirmationModel = Model()
    var LOG_TAG = "InformationPresenter"

    fun addCigaret() {

        infirmationModel.getlocalDatabase().cigaretteDao().insert(
            Cigarette(
                1,
                "Complement",
                infirmationModel.getDataToday(),
                typeCigaret(iInfirmationView.setType()),
                infirmationModel.getSigaretPrice()
            )
        )
        Log.d(LOG_TAG, "start  setCigaret()")
        infirmationModel.upDate()
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
        val number = smokeOnData(infirmationModel.getData(0).get(2)
            , infirmationModel.getData(0).get(1)
            , infirmationModel.getData(0).get(0)
            , infirmationModel.getList())
        if (number > infirmationModel.getLimitSigaret())
        {
            iInfirmationView.overUse()
        }
        if(number >= 10)
        {
            iInfirmationView.setCigaret(  number.toString())
        } else (
                iInfirmationView.setCigaret( "0" + number.toString())
                )

    }

    fun smokeYestordsy() {
        iInfirmationView.setCigaretYestorday(
            smokeOnData(
                infirmationModel.getData(-1).get(2),
                infirmationModel.getData(-1).get(1),
                infirmationModel.getData(-1).get(0),
                infirmationModel.getList()
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
                infirmationModel.getList()
            )
            Log.d(LOG_TAG, "res = $res")
            result += res
        }
        iInfirmationView.setCigaretAverage(result / 7)
    }

    fun smokeOnData(day: String, month: String, year: String, list: List<Cigarette>): Int {
        var variable = 0
        for (i in 0..list.size - 1) {
            var array = list.get(i).datas.split(".")
            Log.d(LOG_TAG, "data $array[2] $array[1] $array[0]")
            if (day.equals(array[2]) && month.equals(array[1]) && year.equals(array[0])) {
                variable += 1
            }
        }
        return variable
    }

    fun smoukeGraf() {
        val list: MutableList<DateMy> = mutableListOf()
        for (i in -8..-1 step 1) {
            smokeOnData(
                infirmationModel.getData(i).get(2),
                infirmationModel.getData(i).get(1),
                infirmationModel.getData(i).get(0),
                infirmationModel.getList()
            )
            var data = DateMy(
                smokeOnData(
                    infirmationModel.getData(i).get(2),
                    infirmationModel.getData(i).get(1),
                    infirmationModel.getData(i).get(0),
                    infirmationModel.getList()
                )
                , infirmationModel.getData(i).get(2) + "." + infirmationModel.getData(i).get(1)
            )

            list.add(data)
        }
        iInfirmationView.Chart(list)
    }


}
