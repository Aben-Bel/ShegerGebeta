package com.abenbel.sheger_gebeta.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abenbel.sheger_gebeta.R
import com.abenbel.sheger_gebeta.RecyclerViewAdapterForFavorite
import com.abenbel.sheger_gebeta.database.AppDatabase
import com.abenbel.sheger_gebeta.database.Food

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@SuppressLint("ValidFragment")
class FavoriteFragment(var db: AppDatabase?) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var layoutManager : RecyclerView.LayoutManager?=null
    private var adapterForFavorite : RecyclerView.Adapter<RecyclerViewAdapterForFavorite.ViewHolder>?=null

    private var foods : ArrayList<Food> = arrayListOf();

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
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onResume() {
        super.onResume()
        foods = arrayListOf();
        foods.addAll(db!!.foodDao().getAll())
        adapterForFavorite?.notifyDataSetChanged();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(activity);
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_favorite)
        recyclerView.layoutManager = layoutManager
        foods = arrayListOf();
        foods.addAll(db!!.foodDao().getAll())
        adapterForFavorite = RecyclerViewAdapterForFavorite(context, foods, db)
        recyclerView.adapter = adapterForFavorite;
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FavoriteFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FavoriteFragment(db).apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}