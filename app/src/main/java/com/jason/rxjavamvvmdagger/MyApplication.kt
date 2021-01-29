package com.jason.rxjavamvvmdagger

import android.app.Application
import android.content.Context
import com.jason.rxjavamvvmdagger.data.di.AppComponent
import com.jason.rxjavamvvmdagger.data.di.DaggerAppComponent

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }

    companion object{
        private lateinit var appContext: Context
        lateinit var appComponent: AppComponent
        fun appContext(): Context {
            return appContext
        }
    }



}