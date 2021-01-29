package com.jason.rxjavamvvmdagger.data.di

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jason.rxjavamvvmdagger.MyApplication
import com.jason.rxjavamvvmdagger.data.network.GoRestService
import com.jason.rxjavamvvmdagger.data.network.baseUrl
import com.jason.rxjavamvvmdagger.ui.MainActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@NetWorkScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(myApplication: MyApplication)
    fun inject(mainActivity: MainActivity)
}

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class NetWorkScope



@Module
class AppModule{
    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return MyApplication.appContext()
    }

}

@Module
class NetworkModule{
    @Provides
    @NetWorkScope
    fun provideGoRestApi(): GoRestService {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(GoRestService::class.java)
    }
}