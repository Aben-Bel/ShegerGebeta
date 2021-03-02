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
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso

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

        fun setMessageWithClickableLink(textView: TextView, content : String) {
            //Clickable Span will help us to make clickable a text
            val startIndex = content.indexOf("https:")
            val endIndex = content.length;
            val url : String = content.slice(startIndex..(endIndex-1));
            Log.i("Debug:: ", url);
            val clickableSpan  = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    //To open the url in a browser
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent);
                }
                override fun updateDrawState(textPaint: TextPaint) {
                    super.updateDrawState(textPaint)
                }
            }
            //SpannableString will be created with the full content and
            // the clickable content all together
            val spannableString = SpannableString(content)
            //only the word 'link' is clickable
            spannableString.setSpan(clickableSpan, startIndex, endIndex + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            //The following is to set the new text in the TextView
            //no styles for an already clicked link
            textView.setText(spannableString)
            textView.setMovementMethod(LinkMovementMethod.getInstance())
            textView.setHighlightColor(Color.TRANSPARENT)
        }
        val desc = findViewById<TextView>(R.id.text_desc_detail)
        setMessageWithClickableLink(desc,intent.getStringExtra("desc"));

        val image = findViewById<ImageView>(R.id.image_view_detail);

        val imageUrl = intent.getStringExtra("image");

        Picasso.get().load(imageUrl).into(avatar);
        Picasso.get().load(imageUrl).into(image);


    }



}