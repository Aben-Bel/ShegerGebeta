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

//        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_home)
//        val data: Array<String> = arrayOf("1","2","3");
//        recyclerView.adapter = CustomeAdapter(data);

    }


    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit();
        }
    }
}

//class CustomeAdapter(val dataSet: Array<String>) : RecyclerView.Adapter<CustomeAdapter.ViewHolder>() {
//        /**
//         * Provide a reference to the type of views that you are using
//         * (custom ViewHolder).
//         */
//        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val textView: TextView
//
//            init {
//                // Define click listener for the ViewHolder's View.
//                textView = view.findViewById(R.id.textView)
//            }
//        }
//
//        // Create new views (invoked by the layout manager)
//        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//            // Create a new view, which defines the UI of the list item
//            val view = LayoutInflater.from(viewGroup.context)
//                .inflate(R.layout.text_row_item, viewGroup, false)
//
//            return ViewHolder(view)
//        }
//
//        // Replace the contents of a view (invoked by the layout manager)
//        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//            // Get element from your dataset at this position and replace the
//            // contents of the view with that element
//            viewHolder.textView.text = dataSet[position]
//
//        }
//
//        // Return the size of your dataset (invoked by the layout manager)
//        override fun getItemCount() = dataSet.size
//}
////
////class CustomAdapter( dataSet: Array<String>) :
////    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
////
////    /**
////     * Provide a reference to the type of views that you are using
////     * (custom ViewHolder).
////     */
////    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
////        val textView: TextView
////
////        init {
////            // Define click listener for the ViewHolder's View.
////            textView = view.findViewById(R.id.textView)
////        }
////    }
////
////    // Create new views (invoked by the layout manager)
////    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
////        // Create a new view, which defines the UI of the list item
////        val view = LayoutInflater.from(viewGroup.context)
////            .inflate(R.layout.text_row_item, viewGroup, false)
////
////        return ViewHolder(view)
////    }
////
////    // Replace the contents of a view (invoked by the layout manager)
////    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
////
////        // Get element from your dataset at this position and replace the
////        // contents of the view with that element
////        viewHolder.textView.text = dataSet[position]
////    }
////
////    // Return the size of your dataset (invoked by the layout manager)
////    override fun getItemCount() = dataSet.size
////
////}