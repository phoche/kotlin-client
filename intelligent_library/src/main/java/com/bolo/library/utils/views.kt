package com.bolo.library.utils

import android.view.View

const val clicksLastTime = 1123460103
const val clicksDelayTime = 1123461123

/**
 * Create by bolo on 2018/5/25
 */

/***
 * 点击事件的View扩展
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener {

    if (clickEnable()) {
        block(it as T)
    }
}

/***
 * 带延迟过滤的点击事件View扩展
 * @param delay Long 延迟时间，默认600毫秒
 * @param block: (T) -> Unit 函数
 * @return Unit
 */
fun <T : View> T.clickWithTrigger(time: Long = 600, block: (T) -> Unit){
    triggerDelay = time
    setOnClickListener {
        if (clickEnable()) {
            block(it as T)
        }
    }
}

private var <T : View> T.triggerLastTime: Long
    get() = if (getTag(clicksLastTime) != null) getTag(clicksLastTime) as Long else 0
    set(value) {
        setTag(clicksLastTime, value)
    }

private var <T : View> T.triggerDelay: Long
    get() = if (getTag(clicksDelayTime) != null) getTag(clicksDelayTime) as Long else -1
    set(value) {
        setTag(clicksDelayTime, value)
    }

private fun <T : View> T.clickEnable(): Boolean {
    var flag = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - triggerLastTime >= triggerDelay) {
        flag = true
    }
    triggerLastTime = currentClickTime
    return flag
}