package com.jason.rxjavamvvmdagger.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jason.rxjavamvvmdagger.data.model.GetAllUserResponse
import com.jason.rxjavamvvmdagger.data.model.User
import com.jason.rxjavamvvmdagger.data.network.GoRestAPI
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

const val TAG: String = "GoRestRepository"

class GoRestRepository @Inject constructor(val goRestAPI: GoRestAPI) {

    fun getAllUser(): MutableLiveData<List<User>> {
        val userLiveData = MutableLiveData<List<User>>()
        val observer = object: DisposableSingleObserver<GetAllUserResponse>(){
            override fun onSuccess(t: GetAllUserResponse) {
                if (t.code == 200){
                    userLiveData.value = t.data
                }
                else{
                    Log.d(TAG, "code ${t.code}")
                }
            }

            override fun onError(e: Throwable) {

                Log.d(TAG, "message ${e.message} cause ${e.cause}")
            }
        }
        goRestAPI.getAllUser(observer)
        return userLiveData
    }




}