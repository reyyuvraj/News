package com.example.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.news.R
import com.example.news.fragment.NewsAboutFragment
import com.example.news.fragment.NewsLicensesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_News)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.drop_down_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuAbout -> {
                val a = supportFragmentManager.beginTransaction()
                supportFragmentManager.popBackStack()
                val frag = NewsAboutFragment()
                a.replace(R.id.nav_host_fragment, frag).addToBackStack("backStack")
                a.commit()
                true
            }
            R.id.menuLicenses -> {
                val a = supportFragmentManager.beginTransaction()
                supportFragmentManager.popBackStack()
                val frag = NewsLicensesFragment()
                a.replace(R.id.nav_host_fragment, frag).addToBackStack("backStack")
                a.commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}