package com.android.techflakepractical.database.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.techflakepractical.database.*


@Entity(tableName = tableGiphyVideos)
class GiphyVideosModel(id: String, imgUrl: String, videoUrl: String, upVote:Int, downVote: Int) {

    constructor() : this("", "","",0,0)

    @PrimaryKey
    @ColumnInfo(name = columnId)
    var id: String = ""

    @ColumnInfo(name = columnImgUrl)
    var imgUrl: String = ""

    @ColumnInfo(name = columnVideoUrl)
    var videoUrl: String = ""

    @ColumnInfo(name = columnUpVote)
    var upVote: Int = 0

    @ColumnInfo(name = columnDownVote)
    var downVote: Int = 0

    init {
        this.id = id
        this.imgUrl = imgUrl
        this.videoUrl = videoUrl
        this.upVote = upVote
        this.downVote = downVote
    }
}
