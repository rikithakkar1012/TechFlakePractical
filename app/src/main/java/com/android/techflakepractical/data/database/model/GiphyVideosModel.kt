package com.android.techflakepractical.data.database.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.techflakepractical.data.database.*
import kotlinx.android.parcel.Parcelize


@Entity(tableName = tableGiphyVideos)
@Parcelize
class GiphyVideosModel() : Parcelable {

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
