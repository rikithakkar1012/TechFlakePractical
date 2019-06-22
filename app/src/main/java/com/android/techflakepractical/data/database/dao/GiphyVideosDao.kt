package com.android.techflakepractical.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.techflakepractical.data.database.columnDownVote
import com.android.techflakepractical.data.database.columnId
import com.android.techflakepractical.data.database.columnUpVote
import com.android.techflakepractical.data.database.model.GiphyVideosModel
import com.android.techflakepractical.data.database.tableGiphyVideos

@Dao
interface GiphyVideosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg giphyVideos: GiphyVideosModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllRecords(giphyVideos: List<GiphyVideosModel>)

    @Query("SELECT * FROM $tableGiphyVideos")
    fun getAllGiphyVideos(): List<GiphyVideosModel>

    @Query("DELETE FROM $tableGiphyVideos")
    fun delete()

    @Query("SELECT * FROM $tableGiphyVideos  WHERE $columnId  = :id")
    fun getGiphyVideoData(id: String): GiphyVideosModel

    @Query("SELECT up_vote FROM $tableGiphyVideos  WHERE $columnId  = :id")
    fun getUpVoteCount(id: String): Int

    @Query("SELECT down_vote FROM $tableGiphyVideos  WHERE $columnId  = :id")
    fun getDownVoteCount(id: String): Int

    @Query("UPDATE $tableGiphyVideos SET $columnUpVote =:count WHERE $columnId = :id")
    fun updateUpVote(count: Int, id: String)

    @Query("UPDATE $tableGiphyVideos SET $columnDownVote =:count WHERE $columnId = :id")
    fun updateDownVote(count: Int, id: String)

}
