package com.abenbel.sheger_gebeta

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.abenbel.sheger_gebeta.fragments.FavoriteFragment
import com.abenbel.sheger_gebeta.fragments.HomeFragment
import com.abenbel.sheger_gebeta.fragments.SearchFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favoriteFragment = FavoriteFragment()
        val searchFragment = SearchFragment()
        
        makeCurrentFragment(homeFragment)

        val bottom_navigation : BottomNavigationView = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_favorite -> makeCurrentFragment(favoriteFragment)
                R.id.ic_search -> makeCurrentFragment(searchFragment)
            }
            true
        }

    }


    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit();
        }
    }
}
