package com.example.mvvmretrofitroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmretrofitroom.jsonToGson.Result
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Result::class], version = 1)
abstract class QuotesDatabse :RoomDatabase() {
    abstract fun quoteDao():QuoteDao

    companion object{
        @Volatile
        private var Instance:QuotesDatabse?=null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context):QuotesDatabse{
           if(Instance==null){
               synchronized(this){
                   Instance=Room.databaseBuilder(
                       context,
                        QuotesDatabse::class.java,
                        "QuotesDB").build()

               }
           }
            return Instance!!


        }


    }
}