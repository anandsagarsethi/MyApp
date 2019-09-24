package com.anand.myapp.tabs

import android.app.Application
import android.content.Context
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anand.myapp.R
import com.anand.myapp.tabs.DataClass.Movies
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieModel(val context: Application): AndroidViewModel(context) {

    private var movies: MutableLiveData<List<Movies>>? = null

    fun getMovies(): LiveData<List<Movies>> {
        if (movies == null) {
            movies = MutableLiveData()
            loadMovies()
        }
        return movies!!
    }

    private fun loadMovies() {

        val gson = Gson()
        val res = context.resources.openRawResource(R.raw.movies).bufferedReader().use { it.readText() }

        val type = object : TypeToken<List<Movies>>(){}.type
        val list = gson.fromJson<List<Movies>>(res, type)

        movies!!.value = list

    }

}