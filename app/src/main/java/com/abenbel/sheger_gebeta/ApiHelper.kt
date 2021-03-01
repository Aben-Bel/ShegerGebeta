package com.abenbel.sheger_gebeta

// Other imported classes
import android.util.Log
import com.abenbel.sheger_gebeta.model.Food
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://10.0.2.2:8080/"

object ApiHelper {

    private val service: ApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(ApiService::class.java)
    }

    fun getFoods(callback: Callback<List<Food>>) {
        val call = service.retrieveFoods()
        call.enqueue(callback)
    }
}