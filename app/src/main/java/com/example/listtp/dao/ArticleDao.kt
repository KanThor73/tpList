package com.example.listtp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.listtp.bo.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM Article WHERE id = :id")
    fun get(id:Long): LiveData<Article>

    @Query("SELECT * FROM Article")
    fun getAll(): LiveData<List<Article>>

    @Insert
    suspend fun insert(article: Article) : Long

    @Insert
    suspend fun insertAll(article: List<Article>)

    @Delete
    suspend fun delete(article: Article)

    @Delete
    suspend fun deleteAll(article: List<Article>)
}