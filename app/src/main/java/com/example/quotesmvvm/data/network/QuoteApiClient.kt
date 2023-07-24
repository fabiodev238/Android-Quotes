package com.example.quotesmvvm.data.network

import retrofit2.Response
import retrofit2.http.GET
import com.example.quotesmvvm.data.model.QuoteModel as QuoteModel

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>// 1 corrutina
    // 2 QuoteService ->  response
    // 3 QuoteRepository -> api ->response
    // 4 GetQuotesUseCase -> repository
    // 5 QuoteViewModel -> result
}