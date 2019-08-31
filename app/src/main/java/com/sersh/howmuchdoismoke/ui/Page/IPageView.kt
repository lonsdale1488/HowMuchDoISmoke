package com.sersh.howmuchdoismoke.ui.Page

interface IPageView {
    fun getWeek():String
    fun getMount():Array<String>
    fun getDay(int: Int):  String?
}