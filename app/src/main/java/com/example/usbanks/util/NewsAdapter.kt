package com.example.usbanks.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usbanks.databinding.ListItemBinding
import com.example.usbanks.model.Article

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var news:  List<Article> = listOf()

    inner class NewsViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: Article) {
            binding.apply {
                title.text = news.title
            }
        }
    }

    fun getTitle(news: List<Article>) {
        this.news = news
       notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder:NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount(): Int = news.size
}