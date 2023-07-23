package com.example.quotesmvvm.data.network

import com.example.quotesmvvm.core.RetrofitHelper
import com.example.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
        return withContext(Dispatchers.IO) {
            response.body() ?: emptyList()
        }
    }
}