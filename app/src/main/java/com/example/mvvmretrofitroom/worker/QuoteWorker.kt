package com.example.mvvmretrofitroom.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.mvvmretrofitroom.application.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(private val context: Context,private val params:WorkerParameters) :Worker(context,params) {
    override fun doWork(): Result {
        Log.e("MyWorker","WorkerCalled")
        val repository=(context as QuoteApplication).repository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getBackgroundQuotes()
        }

        return Result.success()
    }
}