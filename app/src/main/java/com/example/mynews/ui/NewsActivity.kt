package com.example.mynews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mynews.R
import com.example.mynews.databinding.ActivityNewsBinding
import com.example.mynews.db.ArticleDatabase
import com.example.mynews.repository.NewsRepository

class NewsActivity : AppCompatActivity(){

    private lateinit var binding: ActivityNewsBinding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val navController = findNavController(R.id.newsNavHostFragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

}