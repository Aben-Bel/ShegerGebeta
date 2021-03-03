package com.abenbel.sheger_gebeta.database

import androidx.room.*

@Dao
interface FoodDAO {
    @Query("SELECT * FROM foods")
    fun getAll(): List<Food>

    @Insert
    fun insertFood(food: Food)

    @Delete
    fun delete(food: Food)


}
