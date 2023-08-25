package com.example.mvvmretrofitroom.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitroom.jsonToGson.QuoteList
import com.example.mvvmretrofitroom.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Mainviewmodel(private val repository: Repository): ViewModel() {

    init {
        GlobalScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)

        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}