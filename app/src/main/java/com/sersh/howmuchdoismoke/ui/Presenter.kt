package com.sersh.howmuchdoismoke.ui


import com.sersh.howmuchdoismoke.data.Model
import com.sersh.howmuchdoismoke.data.model.Cigarette

abstract class Presenter {
    protected val model = Model()
    private var variable = 0
    private var variableSimilar = 0
    private var variableElectronic = 0


    private fun smokeOnData(
        swichType: Boolean,
        day: String,
        month: String,
        year: String,
        list: List<Cigarette>
    ): Array<Int> {

        for (i in 0..list.size - 1) {

            if (day.equals(splitData(i)[2])
                && month.equals(splitData(i)[1])
                && year.equals(splitData(i)[0])
            ) {
                variable += 1

                if (list.get(i).type.equals("simple")) {
                    variableSimilar += 1
                } else {
                    variableElectronic += 1
                }
            }
        }
        val array: Array<Int> = arrayOf(variable, variableSimilar, variableElectronic)
        array.set(0, variable)
        array.set(1, variableSimilar)
        array.set(2, variableElectronic)
        variable = 0
        variableSimilar = 0
        variableElectronic = 0
        return array
    }

    protected fun smokeOnData(hour: Int, day: String, month: String, year: String, list: List<Cigarette>): Int {
        variable = 0
        for (i in 0..list.size - 1) {
            if (hour == splitData(i)[3].toInt()
                && day.equals(splitData(i)[2])
                && month.equals(splitData(i)[1])
                && year.equals(splitData(i)[0])
            ) {
                variable += 1
            }
        }
        return variable
    }

    fun smokeOnData(month: Int, year: String, list: List<Cigarette>): Int {
        variable = 0
        for (i in 0..list.size - 1) {
            splitData(i)
            if (month == splitData(i)[1].toInt()
                && year.equals(splitData(i)[0])
            ) {
                variable += 1
            }
        }
        return variable
    }

    fun smokeOnData(day: String, month: String, year: String, list: List<Cigarette>): Int {
        variable = 0
        for (i in 0..list.size - 1) {

            if (day.equals(splitData(i)[2])
                && month.equals(splitData(i)[1])
                && year.equals(splitData(i)[0])
            ) {
                variable += 1
            }
        }
        return variable
    }

    private fun splitData(i: Int): List<String> {
        val array1 = model.getList().get(i).datas.split(".")
        return array1
    }

    protected fun getLeatherCigarettes(swichType: Boolean, i: Int): Array<Int> {
        val leatherCigarettes = smokeOnData(
            true,
            model.getData(i).get(2),
            model.getData(i).get(1),
            model.getData(i).get(0),
            model.getList()
        )
        return leatherCigarettes
    }
}