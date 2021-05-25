package com.example.news.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.data.NewsInfo
import com.google.android.material.snackbar.Snackbar

class NewsCategoryAdapter(private val context: Context,
                          private val news: List<NewsInfo>,
                          private val listener: OnNewsClick) :
    RecyclerView.Adapter<NewsCategoryAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_news_category,
                parent,
                false)
        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = news[position]
        holder.newsSource.text = news.author
        holder.newsTitle.text = news.title
        Glide.with(context).load(news.urlToImage).into(holder.newsImage)

        holder.itemView.setOnLongClickListener {
            val publishTime: String = news.publishedAt
            val date = publishTime.slice(0..9)
            val time = publishTime.slice(11..18)
            val snackBar: Snackbar =
                Snackbar.make(it, "News was published on $date at $time", Snackbar.LENGTH_SHORT)
            snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
            snackBar.show()
            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return news.size
    }


    inner class NewsViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val newsSource: TextView = itemView.findViewById(R.id.categorySourceName)
        val newsTitle: TextView = itemView.findViewById(R.id.categoryTitle)
        val newsImage: ImageView = itemView.findViewById(R.id.categoryImage)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(i: View?) {
            val position = adapterPosition
            val pNews = news[position]
            listener.onItemClick(pNews, position)
        }
    }

    interface OnNewsClick{
        fun onItemClick(article:NewsInfo , position: Int)
    }
}