package com.bolo.ktclient.ui.activity

import android.os.Bundle
import com.bolo.ktclient.R
import com.bolo.ktclient.TTPApplication
import com.bolo.ktclient.httpapi.SimpleService
import com.bolo.library.utils.http

class Main2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val retrofit = TTPApplication.mApplicationComponent.retrofit()

        http<String> {
            call = retrofit.create(SimpleService::class.java).accountInfo()

        }
    }
}
