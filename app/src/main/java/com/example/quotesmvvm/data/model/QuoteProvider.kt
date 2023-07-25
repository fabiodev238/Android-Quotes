package com.example.quotesmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton // una sola instancia
class QuoteProvider @Inject constructor() { // cacheo de datos internet
        var quotes: List<QuoteModel> = emptyList() //lista de quotes
}