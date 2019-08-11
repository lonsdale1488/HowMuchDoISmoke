package com.sersh.howmuchdoismoke.data.local

import androidx.room.*
import com.sersh.howmuchdoismoke.data.model.Cigarette

@Dao
interface CigaretteDao {


    @get:Query("SELECT * FROM Cigarette")
    val all: List<Cigarette>


    @Query("SELECT * FROM Cigarette WHERE uid = :uid")
   fun findByName(uid: Int): Cigarette

    @Insert
    fun insert(cigarette: Cigarette)

    @Update
    fun update(cigarette: Cigarette)

    @Query("DELETE FROM Cigarette")
    fun deleteAll()



    @Delete
    fun delete(cigarette: Cigarette)
}

