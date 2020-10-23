package com.dhairytripathi.basictvlauncher2.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dhairytripathi.basictvlauncher2.ui.MainActivity
import com.dhairytripathi.basictvlauncher2.ui.fragments.*

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 6;
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment = SearchFragment()
        when(position){
            0 -> fragment = SearchFragment()
            1 -> fragment = ForYouFragment()
            2 -> fragment = MoviesFragment()
            3 -> fragment = ShowsFragment()
            4 -> fragment = AppsFragment()
            5 -> fragment = LibraryFragment()
        }
        return fragment
    }

}