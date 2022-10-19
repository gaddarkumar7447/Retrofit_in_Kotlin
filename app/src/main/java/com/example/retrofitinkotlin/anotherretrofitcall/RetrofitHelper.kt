package com.example.retrofitinkotlin.anotherretrofitcall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    const val BASE_URL = "https://quotable.io/"
    fun getIntence() : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

}