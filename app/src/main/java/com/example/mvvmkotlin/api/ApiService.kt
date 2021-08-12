package com.example.mvvmkotlin.api

import com.example.mvvmkotlin.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}