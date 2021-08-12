package com.example.mvvmkotlin.repository

import com.example.mvvmkotlin.api.ApiHelper
import com.example.mvvmkotlin.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}