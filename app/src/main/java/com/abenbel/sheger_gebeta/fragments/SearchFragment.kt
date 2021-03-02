package com.abenbel.sheger_gebeta.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.abenbel.sheger_gebeta.R
import com.abenbel.sheger_gebeta.RecyclerViewAdapterForSearch
import com.abenbel.sheger_gebeta.database.AppDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@SuppressLint("ValidFragment")
class SearchFragment(val db: AppDatabase?) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapterForSearch : RecyclerView.Adapter<RecyclerViewAdapterForSearch.ViewHolder>?=null

    private var favImages = intArrayOf(R.drawable.ic_launcher_background)
    private var foodNames = arrayOf("Food 1", "Food 2", "Food 3", "Food 4", "Food 5")
    private var restuarantNames = arrayOf("Restuarant 1", "Restuarant 2", "Restuarant 3", "Restuarant 4", "Restuarant 5")
    private var prices = arrayOf("Price 1", "Price 2", "Price 3", "Price 4", "Price 5")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val search = view.findViewById<SearchView>(R.id.searchView)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_search)
        val restuarant = arrayOf("One", "Two", "Three", "Four")

        layoutManager = LinearLayoutManager(activity);

        recyclerView.layoutManager = layoutManager

        adapterForSearch = RecyclerViewAdapterForSearch(db)
        recyclerView.adapter = adapterForSearch;

//        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                search.clearFocus()
//                if(names.contains(query)){
//                    adapter.filter.filter()
//                }
//            }
//        })

    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment SearchFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            SearchFragment(db).apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}

