package com.abenbel.sheger_gebeta

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.abenbel.sheger_gebeta.database.AppDatabase
import com.abenbel.sheger_gebeta.database.Food
import com.squareup.picasso.Picasso

class RecyclerViewAdapterForFavorite(val context: Context?, var foods: ArrayList<Food>, val db: AppDatabase?) : RecyclerView.Adapter<RecyclerViewAdapterForFavorite.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.recyclerview_model_favorite, p0, false)
        foods = (db?.foodDao()?.getAll() as ArrayList<Food>?)!!;
        return ViewHolder(v);
    }

    override fun onBindViewHolder(p0: RecyclerViewAdapterForFavorite.ViewHolder, p1: Int) {
        val imageUrl = Constant.BASE_URL + foods[p1].imgDir
        Picasso.get().load(imageUrl).into(p0.favImage);
        p0.foodName.text = foods[p1].foodName
        p0.restuarantName.text = foods[p1].placeName
        p0.price.text = foods[p1].price


        val desc : String = "Place: ${foods[p1].placeName}\n" +
                "Food: ${foods[p1].foodName}\n" +
                "Price: ${foods[p1].price}\n" +
                "Google Maps: ${foods[p1].gMapLink}"

        p0.card.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("title", foods[p1].foodName);
                putExtra("desc", desc);
                putExtra("image", imageUrl);
            }
            context?.startActivity(intent)
        }

        p0.shareBtn.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, desc)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            context?.startActivity(shareIntent)
        }
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
        var card : View

        init {
            foodName = itemView.findViewById(R.id.foodTextView)
            restuarantName = itemView.findViewById(R.id.restuarantTextView);
            favImage = itemView.findViewById(R.id.favImageView);
            shareBtn = itemView.findViewById(R.id.shareImageButton);
            price = itemView.findViewById(R.id.priceTextView)
            card = itemView
        }
    }
}