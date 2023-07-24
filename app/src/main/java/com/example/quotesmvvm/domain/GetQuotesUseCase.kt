package com.example.quotesmvvm.domain

import com.example.quotesmvvm.data.QuoteRepository
import com.example.quotesmvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes() // 4 corrutina

}