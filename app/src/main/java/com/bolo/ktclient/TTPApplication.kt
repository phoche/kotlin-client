package com.bolo.ktclient

import android.app.Application
import com.bolo.library.BaseComponent
import com.bolo.library.DaggerBaseComponent
import com.bolo.library.ProviderModule

/**
 * Create by qinpc on 2018/3/26
 */
class TTPApplication : Application() {

    companion object {
        lateinit var mApplicationComponent: BaseComponent
    }

    override fun onCreate() {
        super.onCreate()
        initInjection()

    }

    private fun initInjection() {
        mApplicationComponent = DaggerBaseComponent
                .builder()
                .providerModule(ProviderModule(this,
                        "https://api.github.com/", "ttp_sp"))
                .build()
    }
}