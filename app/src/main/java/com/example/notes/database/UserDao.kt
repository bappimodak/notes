package com.example.callingapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.callingapp.model.UserDetails

@Dao
interface UserDao {

    @Query("SELECT * FROM UserDetails")
    fun getAll(): LiveData<List<UserDetails>>

    @Query("SELECT * FROM UserDetails")
    fun getAlls(): List<UserDetails>

    @Query("SELECT * FROM UserDetails WHERE number LIKE :number")
    fun findByTitle(number: String): UserDetails

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg userDetail: UserDetails)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notes: List<UserDetails>)
}


//in case of conflict while insert: onConflict = OnConflictStrategy.REPLACE

//Returning subsets of columns