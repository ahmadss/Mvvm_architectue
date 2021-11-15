package com.materiajar.mvvmarchitecture.data.api

class ApiHelper(val apiService: ApiService) {
    fun getUsers() = apiService.getUsers()
}