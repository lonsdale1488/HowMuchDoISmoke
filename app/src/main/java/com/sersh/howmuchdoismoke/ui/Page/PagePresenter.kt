package com.sersh.howmuchdoismoke.ui.Page

import com.sersh.howmuchdoismoke.ui.Presenter
import com.sersh.howmuchdoismoke.utils.DateMy

class PagePresenter(var pageView: PageView): Presenter() {
    override fun get() {
    }
    var list: MutableList<DateMy> = arrayListOf()
  fun  getAllList(position: Int):List<DateMy> {

      when (position) {
          0 -> {
          //    var list: MutableList<DateMy> = arrayListOf()
              for (i in 0..24) {
                  var res = smokeOnData(
                      i,
                      model.getData(0).get(2),
                      model.getData(0).get(1),
                      model.getData(0).get(0),
                      model.getList()
                  )
                  list.add(DateMy(res, "$i :00"))
              }
              return list
          }

          1-> {// var list: MutableList<DateMy> = arrayListOf()
              for (i in 0 downTo -20) {
                  if (i == model.getList().size) {
                      break
                  }
                  var res = getLeatherCigarettes(true, i)
                  list.add(DateMy(res.get(0), model.getData(i).get(2) + "." + model.getData(i).get(1)))

              }
              return list
          }
          2 -> {//var list: MutableList<DateMy> = arrayListOf()
              var weekSome = 70
              var result = 0
              var firstData = ""
              var lastData = ""
              for (i in 0 downTo (-1 * weekSome)) {
                  var res = getLeatherCigarettes(true, i)
                  result = result + res.get(0)

                  if (i % 7 == 0 && i != 0) {
                      firstData = model.getData(i - 7).get(2) + "." + model.getData(i - 7).get(1)
                      lastData = model.getData(i).get(2) + "," + model.getData(i).get(1)
                      list.add(DateMy(result, "$firstData - $lastData"))
                      result = 0
                  }
              }
              return list
          }
          3-> {//var list: MutableList<DateMy> = arrayListOf()
              val month: MutableList<String> = arrayListOf(
                  "Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень"
                  , "Серпень", "Вересень", "Жовтень", "Люстопад", "Грудень"
              )

              var result = 0
              for (k in 1..12 ) {

                  var res = smokeOnData(
                      k,
                      model.getData(0).get(0),
                      model.getList())
                  list.add(DateMy(res, month[k - 1]))
                  }
              return list
              }

         else -> {//var list: MutableList<DateMy> = arrayListOf()
              list.add(DateMy(1, "1"))
              list.add(DateMy(2, "2"))
              list.add(DateMy(3, "3"))
              return list
          }
      }
  }

    fun getAllSiagret(position: Int): Array<Int> {
        var first = 0
        var second = 0
        var result = 0
        var resultSimilar = 0
        var resultElectronic = 0
        when (position ) {
           0 -> { first = 0
                second = 0
            }
            1 -> { first = 0
                second = -8
            }
            2 -> { first = 0
                second = -30
            }
            3 -> { first = 0
                second = -365
            }
            else -> {

                for (i in 0..model.getList().size - 1 step 1) {
                    result += model.getList().get(i).numbers
                    if (model.getList().get(i).type.equals("simple")) {
                        resultSimilar += 1
                        continue
                    }
                    resultElectronic += 1
                }
                var array: Array<Int> = arrayOf(result, resultSimilar, resultElectronic)

                return array
            }
        }
        for (i in second..first step 1) {
            if (i == model.getList().size) {
                break
            }
            var res = getLeatherCigarettes(true, i)
            result += res.get(0)
            resultSimilar += res.get(1)
            resultElectronic += res.get(2)
        }
        var array: Array<Int> = arrayOf(result, resultSimilar, resultElectronic)
        return array
    }
}