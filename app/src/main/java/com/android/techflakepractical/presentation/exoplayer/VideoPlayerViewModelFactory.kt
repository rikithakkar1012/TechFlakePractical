package com.android.techflakepractical.presentation.exoplayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VideoPlayerViewModelFactory(private val strId: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(VideoPlayerViewModel(strId)) as T
    }
}