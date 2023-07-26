package com.example.quotesmvvm.domain

import com.example.quotesmvvm.data.QuoteRepository
import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) { //preparada para inyectar -> inyectado

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()

        if (!quotes.isNullOrEmpty()) {

            val randomNumber = (0..quotes.size - 1).random() // ó (quotes.indices).random() Que es lo mismo
            return quotes[randomNumber]
        }
        return null
    }
}