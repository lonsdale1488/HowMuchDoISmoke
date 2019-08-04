package com.sersh.howmuchdoismoke.data.room




import android.app.Application
import androidx.room.Room
import android.util.Log
import com.sersh.howmuchdoismoke.data.local.AppDatabase


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
