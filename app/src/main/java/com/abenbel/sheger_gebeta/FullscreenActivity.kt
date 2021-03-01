package com.abenbel.sheger_gebeta

import android.support.v7.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {
    private lateinit var fullscreenContent: TextView
    private lateinit var fullscreenContentControls: LinearLayout
    private val hideHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)

        val avatar = findViewById<ImageView>(R.id.avatar_detail);
        val title = findViewById<TextView>(R.id.text_title_detail).apply{
            text = intent.getStringExtra("title");
        };
        val desc = findViewById<TextView>(R.id.text_desc_detail).apply{
            text =  intent.getStringExtra("desc")
        };
        val image = findViewById<ImageView>(R.id.image_view_detail);

        val imageUrl = intent.getStringExtra("image");

        Picasso.get().load(imageUrl).into(avatar);
        Picasso.get().load(imageUrl).into(image);


    }

}