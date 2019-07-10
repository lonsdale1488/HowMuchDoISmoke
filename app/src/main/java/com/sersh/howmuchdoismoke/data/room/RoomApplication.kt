package com.sersh.howmuchdoismoke.data.room




import android.app.Application
import android.arch.persistence.room.Room
import android.util.Log


class RoomApplication : Application() {

    var LOG_TAG = "RoomApplication"
    lateinit var db: AppDatabase
companion object {
    var instance: RoomApplication? = null
}




    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "onCreate()")


        db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database"
        )
                .allowMainThreadQueries()
                .build()
        instance = this
        }
}