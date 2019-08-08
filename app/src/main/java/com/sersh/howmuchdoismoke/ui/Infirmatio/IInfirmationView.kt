package com.sersh.howmuchdoismoke.ui.Infirmatio

import com.sersh.howmuchdoismoke.utils.DateMy

interface IInfirmationView {
   fun setCigaret(number:Int)
   fun setCigaretYestorday(number: Int)
   fun setCigaretAverage(number: Int)
   fun Chart (list: MutableList<DateMy>)
   fun setType(): Boolean
   fun overUse()
}