package com.abenbel.sheger_gebeta

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.abenbel.sheger_gebeta.model.Food
import com.squareup.picasso.Picasso


class RecyclerViewAdapterForHome(private var foodList: List<Food>) : RecyclerView.Adapter<RecyclerViewAdapterForHome.ViewHolder>() {

    private val itemTitles = arrayOf("Restuarant 1", "Restaurant 2")
    private val itemDetails = arrayOf("textDesc1","textDesc2");
    private val itemImages = intArrayOf(R.drawable.ic_launcher_background)


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.recyclerview_model_home, p0, false)
        return ViewHolder(v);
    }

    override fun onBindViewHolder(p0: RecyclerViewAdapterForHome.ViewHolder, p1: Int) {
        val item = foodList[p1];
        p0.textTitle.text = item.food_name
        p0.textDesc.text = item.place_name
        val imageUrl = Constant.BASE_URL + item.image_dir
        Picasso.get().load(imageUrl).into(p0.image);
        Picasso.get().load(imageUrl).into(p0.avatar);
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar : ImageView = itemView.findViewById(R.id.avatar)
        var image : ImageView = itemView.findViewById(R.id.image_view)
        var textTitle : TextView = itemView.findViewById(R.id.text_title)
        var textDesc : TextView = itemView.findViewById(R.id.text_desc)
        var favoriteBtn : ImageButton = itemView.findViewById(R.id.favorite_btn)

    }
}