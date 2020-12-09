package com.example.cleanarchitecture.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityHomeBinding
import com.example.cleanarchitecture.presentation.artist.ArtistActivity
import com.example.cleanarchitecture.presentation.movie.MovieActivity
import com.example.cleanarchitecture.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)


        binding.movieButton.setOnClickListener {
            val intent = Intent(this ,MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistButton .setOnClickListener {
            val intent = Intent(this ,ArtistActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this ,TvShowActivity::class.java)
            startActivity(intent)
        }
    }



}