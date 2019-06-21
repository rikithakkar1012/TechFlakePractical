package com.android.techflakepractical.database

import com.android.techflakepractical.database.AppDatabase
import com.android.techflakepractical.database.model.GiphyVideosModel
import java.util.*


class DbGiphyVideos(val db: AppDatabase) {

    fun addGiphyVideos(giphyVideoList: ArrayList<GiphyVideosModel>) {
        db.giphyVideosDao().insertAllRecords(giphyVideoList)
    }

    fun addGiphyVideo(giphyVideoData: GiphyVideosModel){
        db.giphyVideosDao().insert(giphyVideoData)
    }

    fun deleteFamilyMembers() {
        db.giphyVideosDao().delete()
    }

    fun getAllGiphyVideos(): List<GiphyVideosModel> {
        return db.giphyVideosDao().getAllGiphyVideos()
    }

    fun getFamilyMemberType(id: String): GiphyVideosModel {
        return db.giphyVideosDao().getGiphyVideoData(id)
    }


}