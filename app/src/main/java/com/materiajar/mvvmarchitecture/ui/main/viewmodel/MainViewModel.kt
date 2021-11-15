package com.materiajar.mvvmarchitecture.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.materiajar.mvvmarchitecture.data.model.User
import com.materiajar.mvvmarchitecture.data.repository.MainRepository
import com.materiajar.mvvmarchitecture.utils.Resource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    private fun fetchUsers(){
        users.postValue(Resource.loading(null));
        compositeDisposable.add(
            mainRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {userList -> users.postValue(Resource.success(userList))}, {
                        throwable -> users.postValue(Resource.error("Something went Wrong", null))
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    // menggunakan live data
    fun getUsers() : LiveData<Resource<List<User>>>{
        return users
    }
}