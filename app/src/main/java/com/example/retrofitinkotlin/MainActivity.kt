package com.example.retrofitinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : AdapterClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/").build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getDate()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {
                val response = response.body()!!
                adapter = AdapterClass(response)
                recyclerView.adapter = adapter
                /*val stringBuilder = StringBuilder()
                for (myData in responseBody){
                    stringBuilder.append(myData.title)
                    stringBuilder.append("\n")
                }
                textView.text = stringBuilder*/

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Not responding",Toast.LENGTH_SHORT).show()
            }
        })
    }
}