package com.example.cleanarchitecture.presentation.tv

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
import com.example.cleanarchitecture.databinding.ActivityMovieBinding
import com.example.cleanarchitecture.databinding.ActivityTvShowBinding
import com.example.cleanarchitecture.presentation.artist.ArtistViewModel
import com.example.cleanarchitecture.presentation.di.Injector
import com.example.cleanarchitecture.presentation.movie.MovieAdapter
import com.example.cleanarchitecture.presentation.movie.MovieViewModel
import com.example.cleanarchitecture.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvshowViewModel: TvShowViewModel
    private lateinit var adapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvshowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true

    }

    private fun initRecyclerView() {
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayPopularTv()
    }

    private fun displayPopularTv() {
        binding.tvRecyclerView.visibility = View.VISIBLE
        val responseLiveData = tvshowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
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
        binding.tvProgressBar.visibility = View.VISIBLE
        val response = tvshowViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE

            }else{
                binding.tvProgressBar.visibility = View.GONE

            }
        })

    }
}