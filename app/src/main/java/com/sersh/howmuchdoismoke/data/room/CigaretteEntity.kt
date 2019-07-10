package com.sersh.howmuchdoismoke.data.room

import android.arch.persistence.room.*
import android.arch.persistence.room.PrimaryKey



@Entity
class CigaretteEntity
//constructor(@ColumnInfo(name = "number") var number: Int, @ColumnInfo(name = "name") var name: String, @ColumnInfo(
//    name = "data"
//) var data: String
//)
//{
//    @PrimaryKey(autoGenerate = true)
//    var uid: Int = 1
//  //  @ColumnInfo(name = "number")
//    var number: Int = 1
// //   @ColumnInfo(name = "name")
//    var name: String = "gg"
////    @ColumnInfo(name = "data")
//    var data: String = "gg"
//
//}
{

    @PrimaryKey
    var uid: Long = 0

    var name: String? = null

    var salary: Int = 0
}





