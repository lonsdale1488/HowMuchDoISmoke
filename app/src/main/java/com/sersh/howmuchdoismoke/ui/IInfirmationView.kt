package com.sersh.howmuchdoismoke.ui

import com.sersh.howmuchdoismoke.DateMy

interface IInfirmationView {
   fun setCigaret(number:Int)
   fun setCigaretYestorday(number: Int)
   fun setCigaretAverage(number: Int)
   fun Chart (list: MutableList<DateMy>)
}