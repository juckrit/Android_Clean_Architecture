package com.example.cleanarchitecture.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityArtistBinding
import com.example.cleanarchitecture.databinding.ActivityTvShowBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

    }
}