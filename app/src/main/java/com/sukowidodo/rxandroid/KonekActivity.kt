package com.sukowidodo.rxandroid

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sukowidodo.rxandroid.model.ProductsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_konek.*
import retrofit2.Retrofit

class KonekActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konek)
        setSupportActionBar(toolbar)

        val retroclient : Retrofit = RetroClient().getRetrofitInstance()
        val service: RetrofitInterface = retroclient.create(RetrofitInterface::class.java)
        service.getProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result->
                            val listWithNulls: List<ProductsItem?>? = result.products
                            listWithNulls.forEach { productsItem: ProductsItem? -> Unit }

                        },
                        {error ->
                            Log.e("error",error.message)
                        })

    }

}
