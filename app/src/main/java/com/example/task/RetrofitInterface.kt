package com.example.task

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET(value = "users")
    fun getUserData(@Query("page") page: Int) : Call<Userdata>
    // fun getUserData(): Call<Userdata>
}