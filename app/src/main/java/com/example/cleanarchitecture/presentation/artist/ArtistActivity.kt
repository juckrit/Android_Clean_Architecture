package com.example.cleanarchitecture.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityArtistBinding
import com.example.cleanarchitecture.databinding.ActivityTvShowBinding
import com.example.cleanarchitecture.presentation.di.Injector
import com.example.cleanarchitecture.presentation.movie.MovieViewModel
import com.example.cleanarchitecture.presentation.tv.TvAdapter
import com.example.cleanarchitecture.presentation.tv.TvShowViewModel
import com.example.cleanarchitecture.presentation.tv.TvShowViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initRecyclerView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true

    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularTv()
    }

    private fun displayPopularTv() {
        binding.artistRecyclerView.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update->{
                updateTvShows()
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateTvShows() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtist()
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE

            }else{
                binding.artistProgressBar.visibility = View.GONE

            }
        })

    }
}