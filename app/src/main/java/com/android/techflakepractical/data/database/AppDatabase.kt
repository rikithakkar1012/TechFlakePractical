package com.android.techflakepractical.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.techflakepractical.data.database.dao.GiphyVideosDao
import com.android.techflakepractical.data.database.model.GiphyVideosModel


@Database(entities = [GiphyVideosModel::class], version = dbVersion)
abstract class AppDatabase : RoomDatabase() {

    abstract fun giphyVideosDao(): GiphyVideosDao

}
