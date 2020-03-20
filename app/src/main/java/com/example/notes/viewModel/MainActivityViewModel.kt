package com.example.callingapp.viewModel

import android.app.Application
import androidx.annotation.IntegerRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.callingapp.model.UserDetails
import com.example.callingapp.repository.UserDetailsRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var userDetailsRepository: UserDetailsRepository = UserDetailsRepository(application)
    private var userList: LiveData<List<UserDetails>>? = userDetailsRepository.getAllUsersLiveData()

    fun getUserList(): LiveData<List<UserDetails>>? {
        return userList
    }

    fun add(a: Int, b: Int): Int{
        return a + b
    }
}