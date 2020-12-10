package com.example.cleanarchitecture.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.model.artist.Artist
import com.example.cleanarchitecture.data.model.movie.Movie
import com.example.cleanarchitecture.data.model.tvshow.TvShow
import com.example.cleanarchitecture.databinding.ListItemBinding


class ArtistAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()


    fun setList(tvshows:List<Artist>){
        artistList.clear()
        artistList.addAll(tvshows)
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
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(artistList[position])
    }
}



class MyViewHolder(val binding: ListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(artist:Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.name
        val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

   }

}