package com.sukowidodo.rxandroid

import com.sukowidodo.rxandroid.model.ProductsItem
import com.sukowidodo.rxandroid.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by suko on 5/3/18.
 */
interface RetrofitInterface {
    @GET("products.php")
    fun getProducts(): Observable<Response>
}