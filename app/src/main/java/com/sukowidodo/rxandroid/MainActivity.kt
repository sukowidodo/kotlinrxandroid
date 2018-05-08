package com.sukowidodo.rxandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNext.setOnClickListener({view ->
            val intent = Intent(this, KonekActivity::class.java)
            startActivity(intent)
        })
        Observable.create(ObservableOnSubscribe<String> { emitter ->
            etHello.addTextChangedListener(object : TextWatcher{
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = emitter.onNext(p0.toString())

                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

                    override fun afterTextChanged(p0: Editable?) = Unit
                })
                }).debounce(1000, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({t ->
                            tvHello.text = "Output : " + t
                        })

}

}
