package com.example.retrofitinkotlin.anotherretrofitcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitinkotlin.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainQuotes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quotes)

        val quotesAPI = RetrofitHelper.getIntence().create(QuotesAPI::class.java)
        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            Log.d("SEE", result.body().toString())
            val cot = result.body()
            if (cot != null) {
                cot.results.forEach{
                    Log.d("SEE", it.content)
                }
            }
        }
    }
}