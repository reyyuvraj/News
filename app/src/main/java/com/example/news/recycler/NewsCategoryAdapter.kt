package com.example.news.recycler

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.data.NewsInfo
import com.google.android.material.snackbar.Snackbar

class NewsCategoryAdapter(private val context: Context,
                          private val articles: List<NewsInfo>,
                          private val listener: OnNewsClick) :
    RecyclerView.Adapter<NewsCategoryAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_news_category, parent, false)
        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.newsSource.text = article.author
        holder.newsTitle.text = article.title
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

        holder.itemView.setOnClickListener {

            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(article.url))
        }

        holder.itemView.setOnLongClickListener {
            val publishTime: String = article.publishedAt
            val date = publishTime.slice(0..9)
            val time = publishTime.slice(11..18)
            val snackBar: Snackbar =
                Snackbar.make(it, "Published on $date at $time", Snackbar.LENGTH_SHORT)
            snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE
            snackBar.show()
            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }


    inner class NewsViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val newsSource: TextView = itemView.findViewById(R.id.categorySource)
        val newsTitle: TextView = itemView.findViewById(R.id.categoryTitle)
        val newsImage: ImageView = itemView.findViewById(R.id.categoryImage)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            val articleInst = articles[position]
            listener.onItemClick(articleInst, position)
        }
    }

    interface OnNewsClick{
        fun onItemClick(article:NewsInfo , position: Int)
    }
}