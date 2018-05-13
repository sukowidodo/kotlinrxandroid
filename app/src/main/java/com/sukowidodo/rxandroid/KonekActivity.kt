package com.sukowidodo.rxandroid

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sukowidodo.rxandroid.model.ProductsItem
import com.sukowidodo.rxandroid.model.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_konek.*
import retrofit2.Retrofit

class KonekActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konek)
        setSupportActionBar(toolbar)

        val service: RetrofitInterface = RetroClient.getRetrofitInstance().create(RetrofitInterface::class.java)
        getProduct(service)

    }

    fun getProduct(service : RetrofitInterface){
        service.getProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::HandleResponse,this::HandleError)
    }

    fun HandleResponse(response: Response){
        val arai : List<ProductsItem?>? = response.products
        Log.d("Data", arai!![0].name)
    }

    fun HandleError(error:Throwable){
        Log.e("Error",error.message)
    }

}
