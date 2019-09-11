package com.sersh.howmuchdoismoke.ui.Page

import com.sersh.howmuchdoismoke.ui.Presenter
import com.sersh.howmuchdoismoke.utils.DateMy

class PagePresenter(var iPageView: IPageView) : Presenter() {


    var list: MutableList<DateMy> = arrayListOf()
    val hourOnDay = 24
    val dayOnWee = 7
    val weekOnMoun = 4
    val mounOnYear = 12

    private  fun getAllOnDay(): List<DateMy> {
        for (i in 0..hourOnDay) {
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

    private  fun getAllOnWeek(): List<DateMy> {
        for (z in -1 downTo -dayOnWee) {
            if (z == model.getList().size) {
                break
            }
            var res = getLeatherCigarettes(true, z)
            list.add(
                DateMy(
                    res.get(0), iPageView.getDay(model.getDayOFWeek(z)) + ", "
                            + model.getData(z).get(2) + "." + model.getData(z).get(1)
                )
            )
        }
        return list
    }

    private  fun getAllOnMoun(): List<DateMy> {

        var result = 0
        var numberWeek = 0
        for (i in 0 downTo (-1 * weekOnMoun * dayOnWee)) {
            var res = getLeatherCigarettes(true, i)
            result = result + res.get(0)

            if (i % 7 == 0 && i != 0) {
                numberWeek = i / dayOnWee * -1
                list.add(DateMy(result, numberWeek.toString() + " " + iPageView.getWeek()))
                result = 0
            }
        }
        return list
    }

 private fun getAllOnYear(): List<DateMy> {
        for (k in 1..mounOnYear) {

            var res = smokeOnData(
                k,
                model.getData(0).get(0),
                model.getList()
            )
            list.add(DateMy(res, iPageView.getMount()[k - 1]))
        }
        return list
    }


    fun getAllList(position: Int): List<DateMy> {
        when (position) {
            0 -> {
                return  getAllOnDay()
            }
            1 -> {
                return   getAllOnWeek()
            }
            2 -> {
                return   getAllOnMoun()
            }
            3 -> {
                return  getAllOnYear()
            }
            else -> {
                list.add(DateMy(1, "1"))
                list.add(DateMy(2, "2"))
                list.add(DateMy(3, "3"))
                return list
            }
        }
    }
//  fun  getAllList(position: Int) {
//
//      when (position) {
//          0 -> {
//              for (i in 0..hourOnDay) {
//                  var res = smokeOnData(
//                      i,
//                      model.getData(0).get(2),
//                      model.getData(0).get(1),
//                      model.getData(0).get(0),
//                      model.getList()
//                  )
//                  list.add(DateMy(res, "$i :00"))
//              }
//              return list
//          }
//
//          1-> {
//              for (z in -1 downTo -7) {
//                  if (z == model.getList().size) {
//                      break
//                  }
//                  var res = getLeatherCigarettes(true, z)
//                  list.add(DateMy(res.get(0),  iPageView.getDay(model.getDayOFWeek(z)) + ", "
//                          + model.getData(z).get(2) + "." + model.getData(z).get(1)))
//              }
//              return list
//          }
//          2 -> {
//              var weekSome = 28
//              var result = 0
//              var numberWeek = 0
//              for (i in 0 downTo (-1 * weekSome)) {
//                  var res = getLeatherCigarettes(true, i)
//                  result = result + res.get(0)
//
//                  if (i % 7 == 0 && i != 0) {
//                      numberWeek = i/7*(-1)
//                      list.add(DateMy(result, numberWeek.toString() + " " + iPageView.getWeek() ))
//                      result = 0
//                  }
//              }
//              return list
//          }
//          3-> {
//              for (k in 1..12 ) {
//
//                  var res = smokeOnData(
//                      k,
//                      model.getData(0).get(0),
//                      model.getList())
//                  list.add(DateMy(res, iPageView.getMount()[k - 1]))
//                  }
//              return list
//              }
//
//         else -> {//var list: MutableList<DateMy> = arrayListOf()
//              list.add(DateMy(1, "1"))
//              list.add(DateMy(2, "2"))
//              list.add(DateMy(3, "3"))
//              return list
//          }
//      }
//  }

    fun getAllSiagret(position: Int): Array<Int> {
        var first = 0
        var second = 0
        var result = 0
        var resultSimilar = 0
        var resultElectronic = 0
        when (position) {
            0 -> {
                first = 0
                second = 0
            }
            1 -> {
                first = 0
                second = -7
            }
            2 -> {
                first = 0
                second = -30
            }
            3 -> {
                first = 0
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

    fun getLimit(): String {
        return model.getLimitSigaret().toString()
    }
}