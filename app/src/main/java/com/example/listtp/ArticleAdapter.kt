package com.example.listtp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listtp.bo.Article
import com.example.listtp.databinding.CardBinding
import androidx.navigation.fragment.findNavController


class ArticleAdapter(val alArticle: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleVH>() {

    class ArticleVH(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = CardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArticleVH(binding)
    }

    override fun getItemCount(): Int = alArticle.size

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        val article = alArticle[position]
        holder.binding.article = article

    }
}