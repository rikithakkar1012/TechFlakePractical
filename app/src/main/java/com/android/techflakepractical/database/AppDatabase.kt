package com.android.techflakepractical.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.techflakepractical.database.dao.GiphyVideosDao
import com.android.techflakepractical.database.model.GiphyVideosModel


@Database(entities = [GiphyVideosModel::class], version = dbVersion)
abstract class AppDatabase : RoomDatabase() {

    abstract fun giphyVideosDao(): GiphyVideosDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, dbName)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}
