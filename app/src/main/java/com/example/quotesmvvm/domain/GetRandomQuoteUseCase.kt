package com.example.quotesmvvm.domain

import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) { //preparada para inyectar -> inyectado

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes

        if (!quotes.isNullOrEmpty()) {

            val randomNumber = (0..quotes.size - 1).random() // ó (quotes.indices).random() Que es lo mismo
            return quotes[randomNumber]
        }
        return null
    }
}