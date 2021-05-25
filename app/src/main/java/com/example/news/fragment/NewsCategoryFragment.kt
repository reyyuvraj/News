package com.example.news.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.NewsDataItem
import com.example.news.data.NewsInfo
import com.example.news.recycler.NewsCategoryAdapter
import com.example.news.service.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsCategoryFragment : Fragment(), NewsCategoryAdapter.OnNewsClick {

    lateinit var adapter: NewsCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_news_category, container, false)
        val progressbar:ProgressBar = view.findViewById(R.id.progressBar)
        val news = NewsClient.newsCall.getData("in", 1)
        news.enqueue(object: Callback<NewsDataItem> {
            override fun onResponse(call: Call<NewsDataItem>, response: Response<NewsDataItem>) {
                val news = response.body()
                if(news!=null){
                    adapter = NewsCategoryAdapter(context!!,news.articles,
                        this@NewsCategoryFragment)
                    val recyclerView: RecyclerView = view.findViewById(R.id.newsView)
                    progressbar.visibility = View.GONE
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager =  LinearLayoutManager(context)

                }
            }

            override fun onFailure(call: Call<NewsDataItem>, t: Throwable) {
            }
        })
        return view
    }

    override fun onItemClick(article: NewsInfo, position: Int) {
        val bundle = Bundle()
        bundle.putString("url",article.url)
        val fragment = NewsWebFragment()
        Log.d("call","call01")
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,fragment)
            .addToBackStack("Hello").commit()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.drop_down_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}