package com.sukowidodo.rxandroid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductsItem(
		@SerializedName("image")
		@Expose
		val image: String? = null,
		@SerializedName("quantity")
		@Expose
		val quantity: String? = null,
		@SerializedName("productId")
		@Expose
		val productId: String? = null,
		@SerializedName("name")
		@Expose
		val name: String? = null,
		@SerializedName("model")
		@Expose
		val model: String? = null

)
