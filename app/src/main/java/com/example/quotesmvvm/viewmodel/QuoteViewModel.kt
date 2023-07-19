package com.example.quotesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quotesmvvm.model.QuoteModel
import com.example.quotesmvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}
