package com.bolo.ktclient.model

import android.arch.lifecycle.MutableLiveData
import com.bolo.library.utils.http
import com.bolo.ktclient.TTPApplication
import com.bolo.ktclient.httpapi.SimpleService
import com.bolo.ktclient.pojo.GitData
import javax.inject.Inject

/**
 * Create by qinpc on 2018/3/23
 */
class ImageModelImpl @Inject constructor(): IImageModel {

    private val liveData: MutableLiveData<String> = MutableLiveData()

    override fun sendRequest() {
        val retrofit = TTPApplication.mApplicationComponent.retrofit()

        http<MutableList<GitData>> {
            call = retrofit.create(SimpleService::class.java).listRepos("phoche", "kotlin-example")

            success = {
                liveData.value = it.toString()
            }

            failure = {
                liveData.value = it.toString()
            }
        }
    }

    override fun getLiveData() = liveData

}
