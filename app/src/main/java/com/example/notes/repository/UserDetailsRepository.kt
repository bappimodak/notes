package com.example.callingapp.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.callingapp.database.AppDatabase
import com.example.callingapp.database.UserDao
import com.example.callingapp.model.UserDetails
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDetailsRepository(application: Application) {
    private var database: AppDatabase = AppDatabase.getDatabase(application)

    private var userDao: UserDao? = null

    private var allUserDetailsLiveData: LiveData<List<UserDetails>>? = null

    init {
        userDao = database.userDao()
        allUserDetailsLiveData = userDao?.getAll()
    }

    fun insert(userDetails: UserDetails) {
        GlobalScope.launch {
            database.userDao().insertUser(userDetails)
        }
    }

    fun deleteAllNotes() {

    }

    fun getAllUsersLiveData(): LiveData<List<UserDetails>>? {
        return allUserDetailsLiveData
    }
}