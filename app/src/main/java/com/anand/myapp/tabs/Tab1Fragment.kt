package com.anand.myapp.tabs


import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anand.myapp.MainActivity

import com.anand.myapp.R
import com.anand.myapp.tabs.DataClass.Movies
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.tab1_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class Tab1Fragment : Fragment() {
    private val TAG = this.javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab1_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.setHasFixedSize(true)
        val adapter = Tab1RecyclerMovieAdapter(activity!!)
        recyclerView.adapter = adapter

        val  movieViewModel = ViewModelProviders.of(this).get(MovieModel::class.java)

        movieViewModel.getMovies().observe(this, Observer {
            adapter.setList(it)
            Toast.makeText(activity!!, "Change in movies",Toast.LENGTH_SHORT).show()
        } )

        //jst 1-2 classes

        //viewmodel, live data, pagination


        //applicationContext
        //activty context

        //viewmodel
        //repo, source


    }


}
