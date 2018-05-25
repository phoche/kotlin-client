package com.bolo.library.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Create by bolo on 2018/5/25
 */
class RetrofitWrapper<T> {

    var call: Call<T>? = null

    var success: (T) -> Unit = {}

    var failure: (Throwable) -> Unit = {}
}

fun <T> http(init: RetrofitWrapper<T>.() -> Unit) {
    val wrap = RetrofitWrapper<T>()
    wrap.init()
    executeEnqueueRequest(wrap)
}

private fun <T> executeEnqueueRequest(wrap: RetrofitWrapper<T>) {
    wrap.call?.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            t?.let {
                wrap.failure(it)
            }
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response?.body()?.let {
                wrap.success(it)
            }
        }
    })
}
