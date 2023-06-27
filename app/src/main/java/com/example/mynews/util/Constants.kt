package com.example.mynews.util

import com.example.mynews.BuildConfig

class Constants {
    companion object{
        const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://newsapi.org"
        const val SEARCH_NEWS_TIME_DELAY = 500L
    }
}