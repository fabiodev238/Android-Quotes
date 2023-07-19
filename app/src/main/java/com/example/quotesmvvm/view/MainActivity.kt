package com.example.quotesmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.quotesmvvm.databinding.ActivityMainBinding
import com.example.quotesmvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer {// aca hace la subscripcion al viewModel
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        // para toda la pantalla
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()


        }
    }

}