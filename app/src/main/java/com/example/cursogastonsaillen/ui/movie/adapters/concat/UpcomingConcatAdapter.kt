package com.example.cursogastonsaillen.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursogastonsaillen.core.BaseContactHolder
import com.example.cursogastonsaillen.databinding.UpcomingMovieRowBinding
import com.example.cursogastonsaillen.ui.movie.adapters.MovieAdapter

class UpcomingConcatAdapter (private val moviesAdapter: MovieAdapter): RecyclerView.Adapter<BaseContactHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseContactHolder<*> {
        val itemBinding = UpcomingMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseContactHolder<*>, position: Int) {
        when(holder) {
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }
    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: UpcomingMovieRowBinding): BaseContactHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvUpcomingMovies.adapter = adapter
        }
    }

}