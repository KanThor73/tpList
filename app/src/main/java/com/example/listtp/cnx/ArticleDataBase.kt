package com.example.listtp.cnx

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.listtp.bo.Article
import com.example.listtp.dao.ArticleDao

@Database(entities = [Article::class], version = 1)
abstract class ArticleDataBase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDataBase? = null

        fun getInstance(context: Context): ArticleDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context, ArticleDataBase::class.java, "article"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}