package com.abenbel.sheger_gebeta

// Other imported classes
import com.abenbel.sheger_gebeta.model.Food
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object ApiHelper {

    private val service: ApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(ApiService::class.java)
    }

    fun getFoods(callback: Callback<List<Food>>) {
        val call = service.retrieveFoods()
        call.enqueue(callback)
    }
}