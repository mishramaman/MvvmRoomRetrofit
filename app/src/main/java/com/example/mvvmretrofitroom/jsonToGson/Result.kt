package com.example.mvvmretrofitroom.jsonToGson

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val quote_id:Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    //val tags: List<String>
)