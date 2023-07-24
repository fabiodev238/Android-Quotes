package com.example.quotesmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesmvvm.domain.GetQuotesUseCase
import com.example.quotesmvvm.domain.GetRandomQuoteUseCase
import com.example.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>() // progressbar
    var getQuotesUseCase = GetQuotesUseCase()// instancia 5 corrutinas
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

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
        isLoading.postValue(true)// segundo caso de uso
        val quote = getRandomQuoteUseCase()

        if (quote != null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}
