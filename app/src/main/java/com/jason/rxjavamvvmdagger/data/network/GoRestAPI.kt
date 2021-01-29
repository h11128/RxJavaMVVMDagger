package com.jason.rxjavamvvmdagger.data.network

import com.jason.rxjavamvvmdagger.data.model.GetAllUserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GoRestAPI @Inject constructor(val goRestService: GoRestService) {

    fun getAllUser(observer: DisposableSingleObserver<GetAllUserResponse>) {
        goRestService.getAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

}