package com.android.techflakepractical.presentation.exoplayer

import androidx.lifecycle.MutableLiveData
import com.android.techflakepractical.data.database.DbGiphyVideos
import com.android.techflakepractical.presentation.common.BaseViewModel


class VideoPlayerViewModel(val strId: String) : BaseViewModel() {
    val TAG = VideoPlayerViewModel::class.java.simpleName
    var upVote = DbGiphyVideos.getUpVoteCount(strId)
    val countLiveData = MutableLiveData<Int>()
    var downVote = DbGiphyVideos.getDownVoteCount(strId)

    override fun loadPage() {
        super.loadPage()
        countLiveData.value = upVote - downVote
    }

    fun increment() {
        upVote += 1
        DbGiphyVideos.updateUpVoteCount(upVote, strId)
        countLiveData.value = upVote - downVote
    }

    fun decrement() {
//        if ((upVote-downVote) <= 0) {
//            return
//        }
        downVote += 1
        DbGiphyVideos.updateDownVoteCount(downVote, strId)
        countLiveData.value = upVote - downVote
    }
}