package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var MyrecyclerView : RecyclerView
    lateinit var myAdapter: MyAdapter
    lateinit var favbtn : Button
    lateinit var unfavbtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyrecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface ::class.java)

        val retrofitUserdata = retrofitBuilder.getUserData(2)
        retrofitUserdata.enqueue(object : Callback<Userdata?> {
            override fun onResponse(call: Call<Userdata?>, response: Response<Userdata?>) {
            val responseBody = response.body()
               val userList = responseBody?.data!!

                myAdapter = MyAdapter(this@MainActivity, userList)
                MyrecyclerView.adapter = myAdapter
                MyrecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)



            }

            override fun onFailure(call: Call<Userdata?>, t: Throwable) {
                Log.d("Main Activity","onFailure: " + t.message)
            }
        })




    }
}