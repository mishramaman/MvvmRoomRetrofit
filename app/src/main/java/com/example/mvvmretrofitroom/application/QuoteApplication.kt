package com.example.mvvmretrofitroom.application

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager


import com.example.mvvmretrofitroom.retrofirapi.QuotesService
import com.example.mvvmretrofitroom.retrofirapi.RetrofitHelper
import com.example.mvvmretrofitroom.database.QuotesDatabse
import com.example.mvvmretrofitroom.repository.Repository
import com.example.mvvmretrofitroom.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class QuoteApplication:Application() {
    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        initialize()
        setUpWorker()
    }

    private fun setUpWorker() {
        val constraint=Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workRequest=PeriodicWorkRequest.Builder(QuoteWorker::class.java,30,TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)
        }

    private fun initialize() {
        val quotesService= RetrofitHelper.getInstance().create(QuotesService::class.java)
        val database=QuotesDatabse.getDatabase(applicationContext)
        repository=Repository(quotesService,database,applicationContext)
    }

}