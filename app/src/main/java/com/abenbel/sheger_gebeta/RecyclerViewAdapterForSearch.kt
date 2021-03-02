package com.abenbel.sheger_gebeta

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.abenbel.sheger_gebeta.database.AppDatabase

class RecyclerViewAdapterForSearch(db: AppDatabase?) : RecyclerView.Adapter<RecyclerViewAdapterForSearch.ViewHolder>() {
    private var favImages = intArrayOf(R.drawable.ic_launcher_background)
    private var foodNames = arrayOf("Food 1", "Food 2", "Food 3", "Food 4", "Food 5")
    private var restuarantNames = arrayOf("Restuarant 1", "Restuarant 2", "Restuarant 3", "Restuarant 4", "Restuarant 5")
    private var prices = arrayOf("Price 1", "Price 2", "Price 3", "Price 4", "Price 5")


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v: View = LayoutInflater.from(p0.context)
                .inflate(R.layout.recyclerview_model_favorite, p0, false)
        return ViewHolder(v);
    }


    override fun onBindViewHolder(p0: RecyclerViewAdapterForSearch.ViewHolder, p1: Int) {
        p0.itemView
        p0.favImage.setImageResource(favImages[0])
        p0.foodName.text = foodNames[p1]
        p0.restuarantName.text = restuarantNames[p1]
        p0.price.text = prices[p1]
    }

    override fun getItemCount(): Int {
        return foodNames.size;
    }

    class listModel(){
        var foodName: String? = null
        var restuarantName: String? = null
        var favImage: String? = null
        var shareBtn : ImageButton? = null
        var price: String? = null
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
