package com.example.listtp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.listtp.bo.Article
import com.example.listtp.cnx.ArticleDataBase
import com.example.listtp.databinding.FragmentArticleListBinding
import kotlinx.coroutines.launch

class ArticleListFragment : Fragment() {

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var dbGift: ArticleDataBase
    private val articleViewModel: ArticleViewModel by viewModels()
    val articlesToAdd = arrayListOf(
        Article(
            0L,
            "Introduction to Kotlin",
            "Kotlin is a modern programming language.",
            "John Doe"
        ),
        Article(
            0L,
            "Android Development Tips",
            "Learn some tips for efficient Android development.",
            "Jane Smith"
        ),
        Article(
            0L,
            "The Art of Writing Clean Code",
            "Best practices for writing clean and maintainable code.",
            "Alice Johnson"
        ),
        Article(
            0L,
            "Exploring Jetpack Compose",
            "A deep dive into Jetpack Compose for Android UI.",
            "Bob Anderson"
        ),
        Article(
            0L,
            "Kotlin Coroutines Tutorial",
            "Asynchronous programming with Kotlin coroutines.",
            "Emily Brown"
        ),
        Article(
            0L,
            "Getting Started with Spring Boot",
            "Build web applications with Spring Boot.",
            "David Wilson"
        ),
        Article(
            0L,
            "Machine Learning Fundamentals",
            "An overview of machine learning concepts and algorithms.",
            "Sophia Taylor"
        ),
        Article(
            0L,
            "JavaScript ES6 Features",
            "Explore the new features introduced in ECMAScript 6.",
            "Michael Davis"
        ),
        Article(
            0L,
            "Responsive Web Design Principles",
            "Create websites that work well on various devices.",
            "Eva Martinez"
        ),
        Article(
            0L,
            "Introduction to SQL Databases",
            "Basic concepts of relational databases and SQL.",
            "Alex Turner"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var articles: MutableList<Article> = arrayListOf()
        articleViewModel.insert(articlesToAdd)
        if (dbGift.articleDao().getAll() != null) {
            dbGift.articleDao().getAll().observe(viewLifecycleOwner){
                articles = it.toMutableList()
            }
        }

        binding.recyclerArticle.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ArticleAdapter(articles)
        }
    }
}
//        binding.article1.article3Card.setOnClickListener() {
//            ArticleListFragmentDirections.actionListDetail(articles[0]).also {
//                findNavController().navigate(it)
//            }
//        }
//        val articles = arrayListOf<Article>(
//            Article(0L, "Premier aerticle", "contenu du premier article", "Jean-Michel Ecrivain"),
//            Article(1L, "Premier aerticle", "contenu du premier article", "Jean-Michel Ecrivain"),
//            Article(2L, "Premier aerticle", "contenu du premier article", "Jean-Michel Ecrivain"),
//            Article(3L, "Premier aerticle", "contenu du premier article", "Jean-Michel Ecrivain")
//        )
