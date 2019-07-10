package com.sersh.howmuchdoismoke.data.room

import android.arch.persistence.room.*


//@Database(entities = [Weather::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun weatherDao(): WeatherDao
//}

@Database(entities = [CigaretteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cigaretteDao(): CigaretteDao


}