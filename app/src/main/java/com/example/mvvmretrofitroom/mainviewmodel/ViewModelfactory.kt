package com.example.mvvmretrofitroom.mainviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitroom.repository.Repository

class ViewModelfactory(private val repository: Repository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Mainviewmodel(repository) as T
    }
}