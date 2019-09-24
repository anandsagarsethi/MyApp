package com.anand.myapp.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainFragmentViewPager(fm: FragmentManager,val list: List<Fragment>):FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> list.get(0)
            1 -> list.get(1)
            else -> list.get(2)

        }

    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title: String

        when (position){
            0 -> title = "1st Tab"
            1 -> title = "2nd Tab"
            else -> title = "3rd Tab"
        }

       return title
    }

}