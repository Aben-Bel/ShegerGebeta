package com.abenbel.sheger_gebeta


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.abenbel.sheger_gebeta.database.AppDatabase
import com.abenbel.sheger_gebeta.model.Food
import com.squareup.picasso.Picasso


class RecyclerViewAdapterForHome(val context: Context?, private var foodList: List<Food>, val db: AppDatabase?) : RecyclerView.Adapter<RecyclerViewAdapterForHome.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val v: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.recyclerview_model_home, p0, false)
        return ViewHolder(v);
    }

    override fun onBindViewHolder(p0: RecyclerViewAdapterForHome.ViewHolder, p1: Int) {
        val item = foodList[p1];
        p0.textTitle.text = item.food_name
        var text = "Place: ${item.place_name}\n" +
                            "Food: ${item.food_name}\n" +
                            "Price: ${item.price}\n" +
                            "Google Maps: ${item.gmap_link}"
        p0.textDesc.text = text
        val imageUrl = Constant.BASE_URL + item.image_dir
        Picasso.get().load(imageUrl).into(p0.image);
        Picasso.get().load(imageUrl).into(p0.avatar);



        p0.card.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("title", item.food_name);
                putExtra("place", item.place_name)
                putExtra("price", item.price)
                putExtra("maps", item.gmap_link)
                putExtra("desc", text);
                putExtra("image", imageUrl);
            }
            context?.startActivity(intent)
        }

        p0.favoriteBtn.setOnClickListener{
//            Log.i("TAG: ", "Added Food ${item.food_name}")

            var food = com.abenbel.sheger_gebeta.database.Food(item.food_name, item.price, item.place_name, item.gmap_link,imageUrl);

            var inDatabase : Boolean = false
            var dbFood : com.abenbel.sheger_gebeta.database.Food ? = null;
            db!!.foodDao().getAll().forEach{
                if(it == food){
                    dbFood = it;
                    inDatabase = true;
                }
            }
            if (!inDatabase){
                Toast.makeText(p0.card.context,"Added Food ${item.food_name} to favorite",LENGTH_LONG).show()
                db!!.foodDao().insertFood(food)
            }else{
                var status = db!!.foodDao().delete(dbFood!!);
                Toast.makeText(context, "Deleted Food ",Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var card : View = itemView.findViewById(R.id.Card_View)
        var avatar : ImageView = itemView.findViewById(R.id.avatar)
        var image : ImageView = itemView.findViewById(R.id.image_view)
        var textTitle : TextView = itemView.findViewById(R.id.text_title)
        var textDesc : TextView = itemView.findViewById(R.id.text_desc)
        var favoriteBtn : ImageButton = itemView.findViewById(R.id.favorite_btn)
    }
}