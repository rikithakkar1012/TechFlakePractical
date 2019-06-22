package com.android.techflakepractical.data.database

import com.android.techflakepractical.data.database.model.GiphyVideosModel
import com.android.techflakepractical.presentation.app.AppController


object DbGiphyVideos {

    fun addGiphyVideos(giphyVideoList: ArrayList<GiphyVideosModel>) {
        AppController.instance?.getDatabase()?.giphyVideosDao()?.insertAllRecords(giphyVideoList)
    }

    fun addGiphyVideo(giphyVideoData: GiphyVideosModel) {
        AppController.instance?.getDatabase()?.giphyVideosDao()?.insert(giphyVideoData)
    }

    fun deleteGiphyVideos() {
        AppController.instance?.getDatabase()?.giphyVideosDao()?.delete()
    }

    fun getAllGiphyVideos(): List<GiphyVideosModel> {
        return AppController.instance?.getDatabase()?.giphyVideosDao()!!.getAllGiphyVideos()
    }

    fun getUpVoteCount(id: String): Int {
        return AppController.instance?.getDatabase()?.giphyVideosDao()!!.getUpVoteCount(id)
    }

    fun getDownVoteCount(id: String): Int {
        return AppController.instance?.getDatabase()?.giphyVideosDao()!!.getDownVoteCount(id)
    }

    fun updateUpVoteCount(count: Int, id: String) {
        return AppController.instance?.getDatabase()?.giphyVideosDao()!!.updateUpVote(count, id)
    }

    fun updateDownVoteCount(count: Int, id: String) {
        return AppController.instance?.getDatabase()?.giphyVideosDao()!!.updateDownVote(count, id)
    }


}