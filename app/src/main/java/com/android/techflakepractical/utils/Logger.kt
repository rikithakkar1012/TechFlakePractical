package com.android.techflakepractical.utils

import android.util.Log
import com.android.techflakepractical.BuildConfig

object Logger {
    fun d(tag: String, message: Any?) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message.toString())
        }
    }

    fun e(tag: String, message: Any?) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message.toString())
        }
    }

    fun i(tag: String, message: Any?) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message.toString())
        }
    }
}