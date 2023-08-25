package com.example.mvvmretrofitroom.application

import android.app.Application
import com.example.mvvmretrofitroom.retrofirapi.QuotesService
import com.example.mvvmretrofitroom.retrofirapi.RetrofitHelper
import com.example.mvvmretrofitroom.database.QuotesDatabse
import com.example.mvvmretrofitroom.repository.Repository

class QuoteApplication:Application() {
    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quotesService= RetrofitHelper.getInstance().create(QuotesService::class.java)
        val database=QuotesDatabse.getDatabase(applicationContext)
        repository=Repository(quotesService,database,applicationContext)
    }

}