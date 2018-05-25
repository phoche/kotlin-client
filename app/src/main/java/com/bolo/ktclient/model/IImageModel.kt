package com.bolo.ktclient.model

import android.arch.lifecycle.MutableLiveData

/**
 * Create by qinpc on 2018/3/23
 */
interface IImageModel {
    fun sendRequest()

    fun getLiveData(): MutableLiveData<String>?
}