package com.sersh.howmuchdoismoke.ui.Page


import com.sersh.howmuchdoismoke.data.model.Cigarette
import com.sersh.howmuchdoismoke.utils.DateMy


class PagePresenter(var pageView: PageView) {
    private val pageModel by lazy { PageModel(this) }
    private var list: MutableList<DateMy> = arrayListOf()

  fun  getAllList(position: Int):List<DateMy> {
      var int: Int = 0
      if (position == 0)
      { for (i in 0..24)
          {
              var res =  smokeOnHour(
                  i,
                  pageModel.getData(0).get(2),
                  pageModel.getData(0).get(1),
                  pageModel.getData(0).get(0),
                  pageModel.list
              )
              list.add(DateMy(res, "$i :00"))
          }
          return list

      }else
          if (position == 1) {
        //  var list: MutableList<DateMy> = arrayListOf()
          for (i in 0 downTo -20) {
              if (i == pageModel.list.size) {
                  break
              }
              var res = smokeOnData(
                  pageModel.getData(i).get(2),
                  pageModel.getData(i).get(1),
                  pageModel.getData(i).get(0),
                  pageModel.list
              )
              list.add(DateMy(res.get(0), pageModel.getData(i).get(2) + "." + pageModel.getData(i).get(1)))

          }
          return list
      } else if (position == 2) {
        //  var list: MutableList<DateMy> = arrayListOf()
          var weekSome = 70
          var result = 0
          var firstData = ""
          var lastData = ""
          for (i in 0 downTo (-1 * weekSome)) {
              var res = smokeOnData(
                  pageModel.getData(i).get(2),
                  pageModel.getData(i).get(1),
                  pageModel.getData(i).get(0),
                  pageModel.list
              )
              result = result + res.get(0)

              if (i % 7 == 0 && i != 0) {
                  firstData = pageModel.getData(i - 7).get(2) + "." + pageModel.getData(i - 7).get(1)
                  lastData = pageModel.getData(i).get(2) + "," + pageModel.getData(i).get(1)
                  list.add(DateMy(result, "$firstData - $lastData"))
                  result = 0
              }
          }
          return list
      } else if (position == 3)
      {   val month: MutableList<String> = arrayListOf("Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень"
      , "Серпень", "Вересень", "Жовтень", "Люстопад", "Грудень")

        //  var listt: MutableList<DateMy> = arrayListOf()
          var result = 0

          for (k in 1..12 step 1)
          {
          for (i in 0..pageModel.list.size-1 ) {

              if (pageModel.getData(i).get(1).toInt() == k ) {
                  var res = smokeOnData(
                      pageModel.getData(i).get(2),
                      pageModel.getData(i).get(1),
                      pageModel.getData(i).get(0),
                      pageModel.list
                  )
                  result = result + res.get(0)
              }

          }
              list.add(DateMy(result, month[k-1]))
              result = 0
          }
          return list
      }
      else {
       //   var list: MutableList<DateMy> = arrayListOf()
          list.add(DateMy(1, "1"))
          list.add(DateMy(2, "2"))
          list.add(DateMy(3, "3"))
          return list
      }
  }


    fun getAllSiagret(position: Int): Array<Int> {
        var first = 0
        var second = 0
        var result = 0
        var resultSimilar = 0
        var resultElectronic = 0
        if (position == 0) {

        } else if ((position == 1)) {
            first = 0
            second = -8

        } else if ((position == 2)) {
            first = 0
            second = -30
        } else if ((position == 3)) {
            first = 0
            second = -365
        } else {
            for (i in 0..pageModel.list.size-1 step 1) {
                result += pageModel.list.get(i).numbers
                if (pageModel.list.get(i).type.equals("simple")) {
                    resultSimilar += 1
                    continue
                }
                resultElectronic += 1
            }
            var array: Array<Int> = arrayOf(result, resultSimilar, resultElectronic)
            return array
        }

        for (i in second..first step 1) {
            if (i == pageModel.list.size) {
                break
            }
            var res = smokeOnData(
                pageModel.getData(i).get(2),
                pageModel.getData(i).get(1),
                pageModel.getData(i).get(0),
                pageModel.list
            )

            result += res.get(0)
            resultSimilar += res.get(1)
            resultElectronic += res.get(2)
        }
        var array: Array<Int> = arrayOf(result, resultSimilar, resultElectronic)

        return array
    }


    private fun smokeOnData(day: String, month: String, year: String, list: List<Cigarette>): Array<Int> {
        var variable = 0
        var variableSimilar = 0
        var variableElectronic = 0

        for (i in 0..list.size - 1) {

            var array1 = list.get(i).datas.split(".")

            if (day.equals(array1[2]) && month.equals(array1[1]) && year.equals(array1[0])) {
                variable += 1

                if (list.get(i).type.equals("simple")) {
                    variableSimilar += 1
                } else {
                    variableElectronic += 1
                }
            }
        }
        var array: Array<Int> = arrayOf(variable, variableSimilar, variableElectronic)
        array.set(0, variable)
        array.set(1, variableSimilar)
        array.set(2, variableElectronic)
        return array
    }

    private fun smokeOnHour(hour: Int, day: String, month: String, year: String, list: List<Cigarette>): Int {
        var variable = 0

        for (i in 0..list.size - 1) {

            var array1 = list.get(i).datas.split(".")

            if ( hour == array1[3].toInt()  && day.equals(array1[2]) && month.equals(array1[1]) && year.equals(array1[0])) {
                variable += 1
            }
        }
        return variable
    }




//    fun getList (gethours: Boolean, getDay:Boolean, getMonth:Boolean, hours: String ,day: String, month: String, year: String,  list: List<Cigarette>):Int
//    {
//        var variable = 0
//    if (gethours){
//        for (i in 0..list.size - 1) {
//
//            var array1 = list.get(i).datas.split(".")
//
//            if (hours.equals(array1[3]) && day.equals(array1[2]) && month.equals(array1[1]) && year.equals(array1[0])) {
//                variable += 1 }
//        }
//        return variable
//    }


}