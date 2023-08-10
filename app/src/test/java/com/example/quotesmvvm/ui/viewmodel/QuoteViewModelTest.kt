package com.example.quotesmvvm.ui.viewmodel

import com.example.quotesmvvm.domain.GetQuotesUseCase
import com.example.quotesmvvm.domain.GetRandomQuoteUseCase
import com.example.quotesmvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {
    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel


    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first time, get all quotes and set the first value`() =
        runTest {
            //Given
            val quote = listOf(Quote("Holi", "Aris"), Quote("Dame un like", "Otro Aris "))
            coEvery { getQuotesUseCase() } returns quote

            //When
            quoteViewModel.onCreate()

            //Then
            assert(quoteViewModel.quoteModel.value == quote.first())
        }

    @Test
    fun `when randomQuoteUseCase return a quote set on the livedata`() = runTest {
        //Given
        val quote = Quote("Holi", "Aris")
        coEvery { getRandomQuoteUseCase() } returns quote

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

    @Test
    fun `if randomQuoteUseCase return null keep the last value`() = runTest {
        //Given
        val quote = Quote("Aris", "Aris")
        quoteViewModel.quoteModel.value = quote
        coEvery { getRandomQuoteUseCase() } returns null

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

}