package com.ramosoft.wikiparser.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ramosoft.wikiparser.fragment.ArticlesFragment
import com.ramosoft.wikiparser.fragment.CategoryFragment
import com.ramosoft.wikiparser.fragment.ImagesFragment

class ViewPagerAdapter(appCompatActivity : AppCompatActivity) : FragmentStateAdapter(appCompatActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ArticlesFragment()
            1 -> ImagesFragment()
            2 -> CategoryFragment()
            else -> ArticlesFragment()
        }
    }
}