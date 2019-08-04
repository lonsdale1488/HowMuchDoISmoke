package com.sersh.howmuchdoismoke.data.model

import androidx.room.*
import androidx.room.PrimaryKey



@Entity(tableName = "Cigarette")
class Cigarette
constructor( numbers: Int, names: String, datas: String)
{
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    @ColumnInfo(name = "numbers")
    var numbers: Int = numbers
   @ColumnInfo(name = "names")
    var names: String = names
    @ColumnInfo(name = "datas")
    var datas: String = datas

}



//{
//
//    @PrimaryKey
//    var uid: Long = 0
//
//    var name: String? = null
//
//    var salary: Int = 0
//}





