package com.bolo.ktclient.utils

import android.content.Intent
import kotlin.reflect.KProperty

/**
 * Create by qinpc on 2018/4/10
 */
class IntentExtraStringDelegate(val key: String) {
    operator fun getValue(intent: Intent, property: KProperty<*>) = intent.getStringExtra(key)

    operator fun setValue(intent: Intent, property: KProperty<*>, value: String?) {
        intent.putExtra(key, value)
    }
}