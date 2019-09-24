package com.anand.myapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.anand.myapp.tabs.MainFragmentViewPager
import com.anand.myapp.tabs.Tab1Fragment
import com.anand.myapp.tabs.Tab2Fragment
import com.anand.myapp.tabs.Tab3Fragment
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.welcome_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabs = mutableListOf<Fragment>()
        tabs.add(0,Tab1Fragment())
        tabs.add(1,Tab2Fragment())
        tabs.add(2,Tab3Fragment())

        viewPager.adapter = MainFragmentViewPager(childFragmentManager, tabs)
        tabs_layout.setupWithViewPager(viewPager)


    }



}
