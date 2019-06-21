package com.android.techflakepractical.extenstion

import android.view.View
import androidx.core.view.isVisible

fun View.hide() {
    this.isVisible = false
}

fun View.show() {
    this.isVisible = true
}


fun View.invisible() {
    this.visibility = View.INVISIBLE
}