package com.example.mvvmretrofitroom.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitroom.jsonToGson.QuoteList
import com.example.mvvmretrofitroom.retrofirapi.QuotesService
import com.example.mvvmretrofitroom.database.QuotesDatabse
import com.example.mvvmretrofitroom.utils.NetworkUtils

class Repository(
    private val quotesService: QuotesService,
    private val quotesDatabse: QuotesDatabse,
    private val context: Context
) {
    private val QuotesLiveData=MutableLiveData<QuoteList>()
    val quotes :LiveData<QuoteList>
        get() = QuotesLiveData


    suspend fun getQuotes(page: Int) {
        if (NetworkUtils.isInternetAvailable(context)) {
            val result = quotesService.getQuotes(page)
            if (result.body() != null) {
                quotesDatabse.quoteDao().addQuotes(result.body()!!.results)
                QuotesLiveData.postValue(result.body())
            }else{
                val quotes=quotesDatabse.quoteDao().getQuotes()
                val quoteList= QuoteList(1,1,1,quotes,1,1)
                QuotesLiveData.postValue(quoteList)
            }
        }
    }

}