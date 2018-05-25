package com.bolo.ktclient.presenter

import android.arch.lifecycle.LifecycleOwner

/**
 * Create by qinpc on 2018/3/23
 */
interface IImagePresenter {
    fun loadImage(lifecycleOwner: LifecycleOwner)
    fun loadSuccess()
}