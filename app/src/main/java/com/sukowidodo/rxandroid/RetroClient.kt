package com.sukowidodo.rxandroid

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by suko on 5/3/18.
 */
class RetroClient {
    val ROOT_URL : String = "http://tokoperikanan.com/"
    val gson : Gson = GsonBuilder().create()
    fun getRetrofitInstance() : Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(ROOT_URL).build()
}