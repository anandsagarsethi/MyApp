package com.anand.myapp.tabs

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anand.myapp.R
import com.anand.myapp.tabs.DataClass.Movies
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class Tab1RecyclerMovieAdapter (val context:Context):RecyclerView.Adapter<Tab1RecyclerMovieAdapter.ViewHolder>(){

    private var list: List<Movies>? = null

    fun setList(list: List<Movies>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
// this piece connects view holder to each item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (list.isNullOrEmpty()) {
            0
        } else {
            list!!.size
        }
    }

    // it binds the data with each row.

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = list!!.get(position)

        holder.txtMovieName.text = movies.title
        holder.txtMovieYear.text = movies.year.toString()

    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtMovieName = view.txtMovieName
        val txtMovieYear = view.txtMovieYear

    }
}