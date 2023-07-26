package com.example.quotesmvvm.domain.model

import com.example.quotesmvvm.data.database.entities.QuoteEntity
import com.example.quotesmvvm.data.model.QuoteModel

// 5 room
data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain()= Quote(quote, author)
fun QuoteEntity.toDomain()= Quote(quote, author)