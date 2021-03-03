package com.abenbel.sheger_gebeta.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.abenbel.sheger_gebeta.ApiHelper
import com.abenbel.sheger_gebeta.R
import com.abenbel.sheger_gebeta.RecyclerViewAdapterForSearch
import com.abenbel.sheger_gebeta.model.Food
import com.abenbel.sheger_gebeta.model.FoodResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class SearchFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapterForSearch : RecyclerViewAdapterForSearch?=null
    lateinit var recyclerview : RecyclerView


    private var foods : ArrayList<Food> = arrayListOf()
    private var filtered : ArrayList<Food> = arrayListOf()

    private val callback = object: Callback<List<com.abenbel.sheger_gebeta.model.Food>> {
        override fun onFailure(call: Call<List<com.abenbel.sheger_gebeta.model.Food>>?, t:Throwable?) {
            Log.e("MainActivity on failure", "Problem calling API {${t?.message}}")
            Log.e("main", t?.stackTraceToString())
        }

        override fun onResponse(call: Call<List<com.abenbel.sheger_gebeta.model.Food>>?, response: Response<List<com.abenbel.sheger_gebeta.model.Food>>?) {
            response?.isSuccessful.let {
                val resultList = FoodResult(response?.body() ?: emptyList())
                foods.addAll(resultList.entries)
                filtered.addAll(foods);
                recyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        ApiHelper.getFoods(callback)
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
        recyclerview  = view.findViewById(R.id.recycler_view_search)

        layoutManager = LinearLayoutManager(activity);

        recyclerview.layoutManager = layoutManager

        adapterForSearch = RecyclerViewAdapterForSearch(context, filtered)
        recyclerview.adapter = adapterForSearch;

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filtered = foods.filter { it ->
                    it.food_name!!.contains(query.toString()) ||
                            it.price!!.contains(query.toString()) ||
                            it.place_name!!.contains(query.toString())
                } as ArrayList<Food>

                adapterForSearch!!.searchedResult(filtered)
                return true;
            }



            override fun onQueryTextChange(newText: String?): Boolean {
                adapterForSearch!!.searchedResult(foods)
                return false;
            }
        })

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


