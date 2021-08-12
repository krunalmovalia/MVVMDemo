package com.example.mvvmkotlin.api

class ApiHelper(private val apiService: ApiService) {

    fun getUsers() = apiService.getUsers()

}