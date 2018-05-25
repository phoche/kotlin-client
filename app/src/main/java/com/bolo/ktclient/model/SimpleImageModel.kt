package com.bolo.ktclient.model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bolo.library.utils.http
import com.bolo.library.utils.log
import com.bolo.ktclient.TTPApplication
import com.bolo.ktclient.httpapi.SimpleService
import com.bolo.ktclient.pojo.GitData

/**
 * Create by qinpc on 2018/3/30
 */
class SimpleImageModel : ViewModel() {

    private val mLiveData = MutableLiveData<String>()

    fun sendRequest() {
        val retrofit = TTPApplication.mApplicationComponent.retrofit()
        log {
            message = "simpleModel retrofit : $retrofit"
        }

        http<MutableList<GitData>> {
            call = retrofit.create(SimpleService::class.java).listRepos("phoche", "kotlin-example")
            success = {
                val msg = it.toString()
                log {
                    tag = "ImageModelImpl"
                    message = msg
                }
                mLiveData.value = msg
            }

            failure = {
                mLiveData.value = it.toString()
            }
        }
    }

    fun getLiveData() = mLiveData

}