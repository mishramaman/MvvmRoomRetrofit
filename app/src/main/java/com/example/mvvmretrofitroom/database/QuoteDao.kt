package com.example.mvvmretrofitroom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmretrofitroom.jsonToGson.Result


@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM QUOTE")
    suspend fun getQuotes(): List<Result>

}