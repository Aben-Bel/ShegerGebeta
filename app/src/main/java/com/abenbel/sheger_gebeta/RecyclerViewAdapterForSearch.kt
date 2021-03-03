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
import com.abenbel.sheger_gebeta.model.Food

import com.squareup.picasso.Picasso

class RecyclerViewAdapterForSearch(val context: Context?, var foods: ArrayList<Food>) : RecyclerView.Adapter<RecyclerViewAdapterForSearch.ViewHolder>() {
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
        val imageUrl = Constant.BASE_URL + foods[p1].image_dir
        Picasso.get().load(imageUrl).into(p0.favImage);
        p0.foodName.text = foods[p1].food_name
        p0.restuarantName.text = foods[p1].place_name
        p0.price.text = foods[p1].price


        val desc : String = "Place: ${foods[p1].place_name}\n" +
                "Food: ${foods[p1].food_name}\n" +
                "Price: ${foods[p1].price}\n" +
                "Google Maps: ${foods[p1].gmap_link}"

        p0.card.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("title", foods[p1].food_name);
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
        return foods.size;
    }

    fun searchedResult(filter : ArrayList<Food>) {
        foods = filter
        notifyDataSetChanged();
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
