package com.materiajar.mvvmarchitecture.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.materiajar.mvvmarchitecture.data.api.ApiHelper
import com.materiajar.mvvmarchitecture.data.repository.MainRepository
import com.materiajar.mvvmarchitecture.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}