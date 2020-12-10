package com.example.cleanarchitecture.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.model.tvshow.TvShow
import com.example.cleanarchitecture.databinding.ListItemBinding


class TvAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val tvList = ArrayList<TvShow>()

    fun setList(tvshows:List<TvShow>){
        tvList.clear()
        tvList.addAll(tvshows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(tvList[position])
    }
}



class MyViewHolder(val binding: ListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(tvshow:TvShow){
        binding.titleTextView.text = tvshow.name
        binding.descriptionTextView.text = tvshow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvshow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

   }

}