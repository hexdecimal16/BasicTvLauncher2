package com.dhairytripathi.basictvlauncher2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhairytripathi.basictvlauncher2.R
import com.dhairytripathi.basictvlauncher2.adapters.StatusBar
import com.dhairytripathi.basictvlauncher2.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_menu.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.offscreenPageLimit = 6
        pager.adapter = ViewPagerAdapter(this)
        llSearch.setOnFocusChangeListener { view, b ->
            if(b) {
                pager.currentItem = 0
        } }
        rvStatus.adapter = StatusBar(this, pager)
        rvStatus.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvStatus.postDelayed({ rvStatus.getChildAt(0).requestFocus() }, 100)
        pager.currentItem = 1
    }
}