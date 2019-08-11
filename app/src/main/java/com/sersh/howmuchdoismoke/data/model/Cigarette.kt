package com.sersh.howmuchdoismoke.data.model

import androidx.room.*
import androidx.room.PrimaryKey



@Entity(tableName = "Cigarette")
class Cigarette
constructor( numbers: Int, names: String, datas: String, type: String, price: Double  )
{
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    @ColumnInfo(name = "numbers")
    var numbers: Int = numbers
   @ColumnInfo(name = "names")
    var names: String = names
    @ColumnInfo(name = "datas")
    var datas: String = datas
    @ColumnInfo(name = "type")
    var type: String = type
    @ColumnInfo(name = "price")
    var price: Double = price

}





