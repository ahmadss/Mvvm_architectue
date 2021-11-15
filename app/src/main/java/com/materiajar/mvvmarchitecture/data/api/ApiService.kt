package com.materiajar.mvvmarchitecture.data.api

import com.materiajar.mvvmarchitecture.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers() : Single<List<User>>
}