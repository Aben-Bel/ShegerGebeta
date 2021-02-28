package com.abenbel.sheger_gebeta

data class Food(val name: String, val price: String, val restaurant: String, val location: String,
                val gmapLink: String, val imagePath: String, val favorite: Boolean = false)
