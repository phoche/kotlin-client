package com.bolo.library.utils

import java.io.Closeable

/**
 * Create by bolo on 2018/5/25
 */
fun Closeable?.close() {
    try {
        this?.close()
    } catch (e: Exception) {
    }
}