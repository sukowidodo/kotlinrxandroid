package com.sukowidodo.rxandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.Log.d
import com.sukowidodo.rxandroid.model.ProductsItem
import com.sukowidodo.rxandroid.model.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_konek.*

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
                .subscribe(
                        this::HandleResponse,
                        this::HandleError
                )
    }

    fun HandleResponse(response: Response){
        val arai : List<ProductsItem?>? = response.products
        /*d("Data", arai!!.get(0)?.name)*/
        arai?.forEach { ar ->
            d("Data Nama", ar!!.name)
            d("Data ProductId", ar!!.image)
        }

    }

    fun HandleError(error:Throwable){
        Log.e("Error",error.message)
    }

}
