package com.example.mvvmretrofitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitroom.application.QuoteApplication
import com.example.mvvmretrofitroom.mainviewmodel.Mainviewmodel
import com.example.mvvmretrofitroom.mainviewmodel.ViewModelfactory

class MainActivity : AppCompatActivity() {
    lateinit var mainviewmodel: Mainviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).repository
        mainviewmodel = ViewModelProvider(this, ViewModelfactory(repository)).get(Mainviewmodel::class.java)

        mainviewmodel.quotes.observe(this, Observer {
            Toast.makeText(this@MainActivity,it.results.size.toString(),Toast.LENGTH_LONG).show()
        })

    }
}