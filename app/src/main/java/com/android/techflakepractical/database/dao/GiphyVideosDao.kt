package com.android.techflakepractical.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.techflakepractical.database.columnId
import com.android.techflakepractical.database.model.GiphyVideosModel
import com.android.techflakepractical.database.tableGiphyVideos

@Dao
interface GiphyVideosDao {

    @Insert
    fun insert(vararg giphyVideos: GiphyVideosModel)

    @Insert
    fun insertAllRecords(giphyVideos: List<GiphyVideosModel>)

    @Query("SELECT * FROM $tableGiphyVideos")
    fun getAllGiphyVideos(): List<GiphyVideosModel>

    @Query("DELETE FROM $tableGiphyVideos")
    fun delete()

    @Query("SELECT * FROM $tableGiphyVideos  WHERE $columnId  = :id")
    fun getGiphyVideoData(id: String): GiphyVideosModel

}
