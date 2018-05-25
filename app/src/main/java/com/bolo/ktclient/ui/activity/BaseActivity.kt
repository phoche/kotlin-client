package com.bolo.ktclient.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bolo.ktclient.TTPApplication
import com.bolo.ktclient.component.ActivityComponent
import com.bolo.ktclient.component.ActivityModule
import com.bolo.ktclient.component.DaggerActivityComponent

/**
 * Create by qinpc on 2018/3/26
 */
open class BaseActivity: AppCompatActivity() {


    lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()


    }

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent
                .builder()
                .baseComponent(TTPApplication.mApplicationComponent)
                .activityModule(ActivityModule(this))
                .build()
    }
}