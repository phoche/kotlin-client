package com.bolo.ktclient.utils

import android.content.Context
import android.widget.Toast

/**
 * Create by qinpc on 2018/3/26
 */
object ToastUtil {

    private var mToast: Toast? = null

    fun shortToast(context: Context, string: String) {
        mToast?.let { it.cancel() }
        mToast = Toast.makeText(context, string, Toast.LENGTH_SHORT)
        mToast?.let { it.show() }
    }

    fun longToast(context: Context, string: String) {
        mToast?.let { it.cancel() }
        mToast = Toast.makeText(context, string, Toast.LENGTH_LONG)
        mToast?.let { it.show() }
    }
}

