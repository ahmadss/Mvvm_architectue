package com.materiajar.mvvmarchitecture.data.repository

import com.materiajar.mvvmarchitecture.data.api.ApiHelper
import com.materiajar.mvvmarchitecture.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers();
    }
}