package com.abenbel.sheger_gebeta.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Food::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

        abstract fun foodDao()  : FoodDAO


    companion object {
        var INSTANCE: AppDatabase? = null


        fun getFoodDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Shegerb"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

        fun cleanDbObject() {
            INSTANCE = null
        }

    }
}