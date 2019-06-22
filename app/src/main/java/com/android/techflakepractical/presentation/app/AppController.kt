package com.android.techflakepractical.presentation.app

import android.app.Application
import androidx.room.Room
import com.android.techflakepractical.data.database.AppDatabase
import com.android.techflakepractical.data.database.dbName

class AppController : Application() {
    companion object {
        private var appDatabase: AppDatabase? = null
        var instance: AppController? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }

    fun getDatabase(): AppDatabase {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, dbName)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
        return appDatabase as AppDatabase

    }
}