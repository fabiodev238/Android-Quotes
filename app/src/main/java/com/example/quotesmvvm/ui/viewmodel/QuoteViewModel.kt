package com.example.quotesmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesmvvm.domain.GetQuotesUseCase
import com.example.quotesmvvm.domain.GetRandomQuoteUseCase
import com.example.quotesmvvm.data.model.QuoteModel
import com.example.quotesmvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor( // preparada para ser inyectada --0

    private val getQuotesUseCase: GetQuotesUseCase, // instancia 5 corrutinas
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase

) : ViewModel() {

    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>() // progressbar

    fun onCreate() {// // -5 corrutinas en viewModel

        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase() // 5 corrutinas

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])

                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)// segundo caso de uso
            val quote = getRandomQuoteUseCase()

            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }
}
