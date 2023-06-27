package com.example.mynews.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mynews.R
import com.example.mynews.databinding.FragmentArticleBinding
import com.example.mynews.ui.NewsActivity
import com.example.mynews.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    lateinit var binding: FragmentArticleBinding
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        binding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved succesfully", Snackbar.LENGTH_SHORT).show()
        }



    }

}