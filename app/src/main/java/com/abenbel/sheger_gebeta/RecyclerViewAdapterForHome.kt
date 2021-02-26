package com.abenbel.sheger_gebeta

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RecyclerViewAdapterForHome : RecyclerView.Adapter<RecyclerViewAdapterForHome.ViewHolder>() {

    private val itemTitles = arrayOf("Restuarant 1", "Restaurant 2")
    private val itemDetails = arrayOf("textDesc1","textDesc2");
    private val itemImages = intArrayOf(R.drawable.ic_launcher_background)


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.recyclerview_model_home, p0, false)
        return ViewHolder(v);
    }


    override fun onBindViewHolder(p0: RecyclerViewAdapterForHome.ViewHolder, p1: Int) {
        p0.textTitle.text = itemTitles[p1]
        p0.textDesc.text = itemDetails[p1]
        p0.image.setImageResource(itemImages[0])
        p0.avatar.setImageResource(itemImages[0])
    }

    override fun getItemCount(): Int {
        return itemTitles.size;
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar : ImageView
        var image : ImageView
        var textTitle : TextView
        var textDesc : TextView
        var favoriteBtn : Button

        init {
            avatar = itemView.findViewById(R.id.avatar)
            image = itemView.findViewById(R.id.image_view);
            textTitle = itemView.findViewById(R.id.text_title);
            textDesc = itemView.findViewById(R.id.text_desc);
            favoriteBtn = itemView.findViewById(R.id.favorite_btn)
        }
    }


}