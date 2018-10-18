package com.bolo.library.utils

import android.content.pm.PackageManager
import android.os.Environment
import com.bolo.library.App
import java.io.Closeable
import java.io.File

/**
 * Create by bolo on 2018/5/25
 */
private const val EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE"

fun Closeable?.close() {
    try {
        this?.close()
    } catch (e: Exception) {
    }
}

fun getFileDirectory(): File? {
    return if (existSDCard() && hasExternalStoragePermission()) {
        val dataDir = File(File(Environment.getExternalStorageDirectory(), "Android"), "data")
        File(File(dataDir, App.mContext.packageName), "file")
    } else {
        App.mContext.filesDir
    }
}

fun existSDCard(): Boolean {
    var externalStorageState = try {
        Environment.getExternalStorageState()
    } catch (e: NullPointerException) { // (sh)it happens (Issue #660)
        ""
    }

    return Environment.MEDIA_MOUNTED == externalStorageState
}

private fun hasExternalStoragePermission(): Boolean {
    return App.mContext
            .checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) == PackageManager.PERMISSION_GRANTED
}