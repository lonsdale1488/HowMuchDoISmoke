package com.sersh.howmuchdoismoke.data.local

import androidx.room.*
import com.sersh.howmuchdoismoke.data.model.Cigarette

@Database(entities = [Cigarette::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cigaretteDao(): CigaretteDao
}