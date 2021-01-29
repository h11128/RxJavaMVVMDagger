package com.jason.rxjavamvvmdagger.data

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jason.rxjavamvvmdagger.data.model.User
import javax.inject.Inject

class GoRestViewModel @Inject constructor(val goRestRepository: GoRestRepository): ViewModel() {
    var userLiveData = MutableLiveData<List<User>>()

    fun getAllUser(){

        val data = goRestRepository.getAllUser()

        val observer = Observer<List<User>>{
            if (it!= null){
                userLiveData.value = it
            }
        }
        data.observeForever(observer)

    }

    override fun onCleared() {

        super.onCleared()

    }







}