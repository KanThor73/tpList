package com.example.listtp

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listtp.bo.Article
import com.example.listtp.cnx.ArticleDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleViewModel(application: Application) : ViewModel() {
    private lateinit var dbGift: ArticleDataBase
    val articles = MutableLiveData(null)
    val context = application.applicationContext

    init {
        dbGift= ArticleDataBase.getInstance(context)
    }

    fun insert(articles: List<Article>) = viewModelScope.launch(Dispatchers.IO) {
        dbGift.articleDao().insertAll(articles)
    }
}