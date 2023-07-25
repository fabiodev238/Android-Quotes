package com.example.quotesmvvm.data.network

import com.example.quotesmvvm.core.RetrofitHelper
import com.example.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// provee QuoteApiClient de retrofit
class QuoteService @Inject constructor(private val api: QuoteApiClient) { //preparada para inyectar -> inyectado  ----3

    suspend fun getQuotes(): List<QuoteModel> {
        val response = api.getAllQuotes()// 2 corrutina

        return withContext(Dispatchers.IO) {
            response.body() ?: emptyList()
        }
    }
}