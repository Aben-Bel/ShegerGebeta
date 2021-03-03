package com.abenbel.sheger_gebeta

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.*
import com.abenbel.sheger_gebeta.database.AppDatabase
import com.squareup.picasso.Picasso

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class DetailsActivity : AppCompatActivity() {
    private lateinit var fullscreenContent: TextView
    private lateinit var fullscreenContentControls: LinearLayout
    private val hideHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)

        val avatar = findViewById<ImageView>(R.id.avatar_detail);
        val foodName = intent.getStringExtra("title")
        val imageUrl = intent.getStringExtra("image");
        val place = intent.getStringExtra("place");
        val price = intent.getStringExtra("price");
        val maps = intent.getStringExtra("maps");

        val mapTextView = findViewById<TextView>(R.id.map_link)
        mapTextView.setText("Goole Maps: ${maps}" )
        val descriptionView = findViewById<TextView>(R.id.text_desc_detail)


        val description : String = "Place: ${place}\n" +
                "Food: ${foodName}\n" +
                "Price: ${price}\n";
        descriptionView.text = description


        findViewById<TextView>(R.id.text_title_detail).apply{
            text = intent.getStringExtra("title");
        };
        val image = findViewById<ImageView>(R.id.image_view_detail);

        Picasso.get().load(imageUrl).into(avatar);
        Picasso.get().load(imageUrl).into(image);

        val db = AppDatabase.getFoodDatabase(this);
        val favBtn = findViewById<ImageButton>(R.id.favorite_btn_detail)

        favBtn.setOnClickListener {
            var inDatabase : Boolean = false

            var food = com.abenbel.sheger_gebeta.database.Food(foodName, price, place, maps,imageUrl)
            var dbFood : com.abenbel.sheger_gebeta.database.Food ? = null;
            db!!.foodDao().getAll().forEach{
                if(it == food){
                    dbFood = it;
                    inDatabase = true;
                }
            }
            if (!inDatabase){
                Toast.makeText(this,"Added Food ${foodName} to favorite",
                    Toast.LENGTH_LONG
                ).show()
                db!!.foodDao().insertFood(food)
            }else {
                var status = db!!.foodDao().delete(dbFood!!);
                Toast.makeText(this, "Deleted Food",Toast.LENGTH_SHORT).show();
            }
        }

    }





}