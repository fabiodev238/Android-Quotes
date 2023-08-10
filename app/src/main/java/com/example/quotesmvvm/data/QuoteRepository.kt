package com.example.quotesmvvm.data

import com.example.quotesmvvm.data.database.dao.QuoteDao
import com.example.quotesmvvm.data.database.entities.QuoteEntity
import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.data.network.QuoteService
import com.example.quotesmvvm.domain.model.Quote
import com.example.quotesmvvm.domain.model.toDomain
import javax.inject.Inject


class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {//preparada para inyectar -> inyectado  ----2

    suspend fun getAllQuotesFromApi(): List<Quote> { //4 room

        val response: List<QuoteModel> = api.getQuotes()   // llama backend y recupera la citas -> 3 corrutina
        return response.map { it.toDomain() }                               // devuelvo la respuesta de todas las citas
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}