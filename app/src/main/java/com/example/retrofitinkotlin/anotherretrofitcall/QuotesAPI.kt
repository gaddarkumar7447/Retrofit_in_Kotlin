package com.example.retrofitinkotlin.anotherretrofitcall

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {
    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int): Response<QutoesDataItem>
}