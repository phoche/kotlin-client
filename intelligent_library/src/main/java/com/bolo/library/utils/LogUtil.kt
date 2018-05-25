package com.bolo.library.utils

import android.util.Log

/**
 * Create by bolo on 2018/5/25
 */
const val isDebug = true

class LogWrapper {
    var level: Int = Log.INFO
    var tag: String = ""
    var message: String = ""
}

fun log(init: LogWrapper.() -> Unit) {
    val wrap = LogWrapper()
    wrap.init()
    executePrint(wrap)
}

private fun executePrint(wrap: LogWrapper) {
    if (isDebug) {
        when (wrap.level) {
            Log.INFO -> Log.i(wrap.tag, wrap.message)
            Log.ERROR -> Log.e(wrap.tag, wrap.message)
            Log.WARN -> Log.w(wrap.tag, wrap.message)
        }
    }
}