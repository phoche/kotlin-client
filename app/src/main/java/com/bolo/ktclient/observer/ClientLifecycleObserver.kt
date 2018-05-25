package com.bolo.ktclient.observer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

/**
 * Create by qinpc on 2018/3/29
 */
class ClientLifecycleObserver : LifecycleObserver {

    companion object {
        val TAG = "ClientLifecycleObserver"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
    }

}