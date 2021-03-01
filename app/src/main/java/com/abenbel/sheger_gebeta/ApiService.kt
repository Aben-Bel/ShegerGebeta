package com.abenbel.sheger_gebeta

import com.abenbel.sheger_gebeta.model.Food
import com.abenbel.sheger_gebeta.model.FoodResult
import retrofit2.http.GET
import retrofit2.Call;

interface ApiService {

    @GET("/")
    fun retrieveFoods(): Call<List<Food>>

}