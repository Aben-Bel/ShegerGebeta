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
class FirstScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_screen)


    }


    fun goToHomePage(view: View) {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
//        finish()
    }



}