package com.ramosoft.wikiparser.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ramosoft.wikiparser.R
import com.ramosoft.wikiparser.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener{ item ->
        when (item.itemId) {
            R.id.articlesFragment -> {
                viewPager.currentItem = 0
                return@OnItemSelectedListener true
            }
            R.id.imagesFragment -> {
                viewPager.currentItem = 1
                return@OnItemSelectedListener true
            }
            R.id.categoryFragment -> {
                viewPager.currentItem = 2
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager=findViewById<ViewPager2>(R.id.viewPager)
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomNavigationView.menu.findItem(R.id.articlesFragment).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.imagesFragment).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.categoryFragment).isChecked = true
                }
            }
        })

    }
}