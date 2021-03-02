package com.abenbel.sheger_gebeta

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.abenbel.sheger_gebeta.database.AppDatabase
import com.abenbel.sheger_gebeta.database.Food
import com.squareup.picasso.Picasso

class RecyclerViewAdapterForFavorite(var foods : ArrayList<Food>, val db: AppDatabase?) : RecyclerView.Adapter<RecyclerViewAdapterForFavorite.ViewHolder>() {

    private var favImages = intArrayOf(R.drawable.ic_launcher_background)
    private var foodNames = arrayOf("Food 1", "Food 2", "Food 3", "Food 4", "Food 5")
    private var restuarantNames = arrayOf("Restuarant 1", "Restuarant 2", "Restuarant 3", "Restuarant 4", "Restuarant 5")
    private var prices = arrayOf("Price 1", "Price 2", "Price 3", "Price 4", "Price 5")


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.recyclerview_model_favorite, p0, false)
        Toast.makeText(p0.context, "Favorite DB", Toast.LENGTH_LONG).show()
        foods = (db?.foodDao()?.getAll() as ArrayList<Food>?)!!;
        return ViewHolder(v);
    }

    override fun onBindViewHolder(p0: RecyclerViewAdapterForFavorite.ViewHolder, p1: Int) {
        Toast.makeText(p0.itemView.context, "onBindView", Toast.LENGTH_LONG).show()
        val imageUrl = Constant.BASE_URL + foods[p1].imgDir
        Picasso.get().load(imageUrl).into(p0.favImage);
        p0.foodName.text = foods[p1].foodName
        p0.restuarantName.text = foods[p1].placeName
        p0.price.text = foods[p1].price
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var foodName: TextView
        var restuarantName: TextView
        var favImage: ImageView
        var shareBtn : ImageButton
        var price: TextView


        init {
            foodName = itemView.findViewById(R.id.foodTextView)
            restuarantName = itemView.findViewById(R.id.restuarantTextView);
            favImage = itemView.findViewById(R.id.favImageView);
            shareBtn = itemView.findViewById(R.id.shareImageButton);
            price = itemView.findViewById(R.id.priceTextView)
        }
    }
}