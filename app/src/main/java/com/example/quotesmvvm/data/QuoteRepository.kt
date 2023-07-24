package com.example.quotesmvvm.data

import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.data.model.QuoteProvider
import com.example.quotesmvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{

        val response = api.getQuotes()// llama backend y recupera la citas -> 3 corrutina
        QuoteProvider.quotes =  response// En var quotes guardo la respuesta (response) del servidor -> mini DataBase
        return response // devuelvo la respuesta
    }
}