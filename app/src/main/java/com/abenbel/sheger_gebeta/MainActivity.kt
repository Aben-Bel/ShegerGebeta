package com.abenbel.sheger_gebeta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this);
        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter;
//        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
//        val data: Array<String> = arrayOf("1","2","3");
//        recyclerView.adapter = CustomeAdapter(data);

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