package com.abenbel.sheger_gebeta

import com.abenbel.sheger_gebeta.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    fun retrieveFoods(): Call<List<Food>>

}