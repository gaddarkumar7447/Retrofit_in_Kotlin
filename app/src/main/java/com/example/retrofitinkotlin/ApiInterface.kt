package com.example.retrofitinkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getDate () : Call<List<MyDataItem>>
}