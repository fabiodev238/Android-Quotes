package com.example.quotesmvvm.data

import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.data.model.QuoteProvider
import com.example.quotesmvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider) {//preparada para inyectar -> inyectado  ----2

    suspend fun getAllQuotes(): List<QuoteModel> {

        val response = api.getQuotes()// llama backend y recupera la citas -> 3 corrutina
        quoteProvider.quotes = response// En var quotes guardo la respuesta (response) del servidor -> mini DataBase
        return response // devuelvo la respuesta de todas las citas
    }
}