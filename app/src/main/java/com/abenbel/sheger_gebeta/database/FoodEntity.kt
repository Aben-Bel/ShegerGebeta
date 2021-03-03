package com.abenbel.sheger_gebeta.database;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(
    @ColumnInfo(name = "food_name") val foodName: String?,
    @ColumnInfo(name = "price") val price: String?,
    @ColumnInfo(name = "place_name") val placeName: String?,
    @ColumnInfo(name = "gmap_link") val gMapLink: String?,
    @ColumnInfo(name = "image_dir") val imgDir: String?,
    @ColumnInfo(name = "favorite") val favorite : Boolean
){
    @PrimaryKey(autoGenerate = true)
    var foodId: Int =0
}