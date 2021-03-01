package com.abenbel.sheger_gebeta.model

data class Food(val food_name: String, val price: String, val place_name: String, val location_description: String,
                val gmap_link: String, val image_dir: String, val favorite: Boolean = false)