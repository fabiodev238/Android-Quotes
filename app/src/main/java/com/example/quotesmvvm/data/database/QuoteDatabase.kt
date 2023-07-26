package com.example.quotesmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quotesmvvm.data.database.dao.QuoteDao
import com.example.quotesmvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1) //3 room
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao


}