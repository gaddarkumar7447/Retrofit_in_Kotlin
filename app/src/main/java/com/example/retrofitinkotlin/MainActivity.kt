package com.example.retrofitinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitinkotlin.anotherretrofitcall.MainQuotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapterClass : AdapterClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getMyData()
        findViewById<Button>(R.id.button).setOnClickListener{
            startActivity(Intent(this, MainQuotes::class.java))
        }
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/").build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getDate()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {

                val res = response.body()!!
                adapterClass = AdapterClass(res)
                recyclerView.adapter = adapterClass

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