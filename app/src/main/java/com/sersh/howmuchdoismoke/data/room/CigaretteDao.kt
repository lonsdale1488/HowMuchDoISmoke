package com.sersh.howmuchdoismoke.data.room

import androidx.room.*


@Dao
interface CigaretteDao {



    @get:Query("SELECT * FROM Cigarette")
    val all: List<Cigarette>


// can create problem
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

//@Dao
//interface BillDao {
//
//    @get:Query("SELECT * FROM bill")
//    val all: List<Bill>
//
//    @Query("SELECT * FROM bill WHERE uid IN (:billIds)")
//    fun loadAllByIds(billIds: Array<Int>): List<Bill>
//
//    @Query("SELECT * FROM bill WHERE customer_id = :uid")
//    fun findByCustomerId(uid: Int): List<Bill>
//
//    @Insert
//    fun insertAll(bills: List<Bill>)
//
//    @Insert
//    fun insert(bill: Bill)
//
//    @Delete
//    fun delete(bill: Bill)
//
//}


//@Dao
//interface CustomerDao {
//
//    @get:Query("SELECT * FROM customer")
//    val all: List<Customer>
//
//    @Query("SELECT * FROM customer WHERE uid IN (:customersId)")
//    fun loadAllByIds(customersId: Array<Int>): List<Customer>
//
//    @Query("SELECT * FROM customer WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): Customer
//
//    @Insert
//    fun insertAll(customers: List<Customer>)
//
//    @Delete
//    fun delete(client: Customer)
//
//}