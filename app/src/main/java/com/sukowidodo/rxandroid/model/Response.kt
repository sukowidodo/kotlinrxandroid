package com.sukowidodo.rxandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(
		@SerializedName("products")
		@Expose
		val products: List<ProductsItem?>? = null
)
