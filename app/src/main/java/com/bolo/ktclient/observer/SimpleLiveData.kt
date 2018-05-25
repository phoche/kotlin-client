package com.bolo.ktclient.observer

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData

/**
 * Create by qinpc on 2018/3/30
 */
object SimpleLiveData : LiveData<String>() {

    private lateinit var mLifecycleOwner: LifecycleOwner

    fun set(lifecycleOwner: LifecycleOwner) : LiveData<String> {
        mLifecycleOwner = lifecycleOwner
        return this
    }

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}