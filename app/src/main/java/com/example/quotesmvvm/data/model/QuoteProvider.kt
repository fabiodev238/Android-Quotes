package com.example.quotesmvvm.data.model

import com.example.quotesmvvm.data.model.QuoteModel

class QuoteProvider {
    companion object {

        var quotes: List<QuoteModel> = emptyList()
    }
}