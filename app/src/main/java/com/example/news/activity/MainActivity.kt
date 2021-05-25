package com.example.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.news.R
import com.example.news.fragment.NewsAboutFragment
import com.example.news.fragment.NewsLicensesFragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_News)
        setContentView(R.layout.activity_main)
    }
}















/*

private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_News)
        setContentView(R.layout.activity_main)

        val nav = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = nav.navController

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.drop_down_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuAbout -> {
                navController.navigate(R.id.action_newsCategoryFragment_to_newsAboutFragment)
            }
            R.id.menuLicenses -> {
                navController.navigate(R.id.action_newsCategoryFragment_to_newsLicensesFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
*/