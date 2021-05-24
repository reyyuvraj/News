package com.example.news.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.news.R

class NewsWebFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_news_web, container, false)
        val url :String = arguments?.getString("url").toString()
        view.findViewById<WebView>(R.id.webView).webViewClient = WebViewClient()
        view.findViewById<WebView>(R.id.webView).loadUrl(url)
        return view
    }
}