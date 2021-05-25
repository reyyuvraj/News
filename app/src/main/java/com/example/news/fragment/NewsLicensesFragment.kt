package com.example.news.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.news.R


class NewsLicensesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val licenseIds: ArrayList<Int> = ArrayList()
        //licenseIds.add(LicenseID.GSON) // Add License ID from LicenseID class
        //licenseIds.add(LicenseID.RETROFIT) // Add License ID from LicenseID class

        return inflater.inflate(R.layout.fragment_news_licenses, container, false)

    }
}

































/*

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.clear()
    }

 */