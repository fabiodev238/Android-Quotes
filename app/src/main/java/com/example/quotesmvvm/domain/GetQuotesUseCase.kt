package com.example.quotesmvvm.domain

import com.example.quotesmvvm.data.QuoteRepository
import com.example.quotesmvvm.data.database.entities.toDatabase
import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) { //preparada para inyectar -> inyectado  ----1

    suspend operator fun invoke(): List<Quote> {// 4 corrutina
        val quotes = repository.getAllQuotesFromApi()

       return if (quotes.isNotEmpty()) {

            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
           quotes
        } else {
            repository.getAllQuotesFromDatabase()

        }
    }
}
