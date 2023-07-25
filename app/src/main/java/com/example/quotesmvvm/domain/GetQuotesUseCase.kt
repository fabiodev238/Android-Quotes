package com.example.quotesmvvm.domain

import com.example.quotesmvvm.data.QuoteRepository
import com.example.quotesmvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) { //preparada para inyectar -> inyectado  ----1

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes() // 4 corrutina

}