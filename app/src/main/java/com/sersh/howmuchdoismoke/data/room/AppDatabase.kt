package com.sersh.howmuchdoismoke.data.room

import androidx.room.*


//@Database(entities = [Weather::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun weatherDao(): WeatherDao
//}

@Database(entities = [Cigarette::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cigaretteDao(): CigaretteDao
}