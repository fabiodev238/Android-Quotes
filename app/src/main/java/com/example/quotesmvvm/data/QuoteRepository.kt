package com.example.quotesmvvm.data

import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.data.model.QuoteProvider
import com.example.quotesmvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{

        val response = api.getQuotes()
        QuoteProvider.quotes =  response
        return response
    }
}