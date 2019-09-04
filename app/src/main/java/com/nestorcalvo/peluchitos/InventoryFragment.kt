package com.nestorcalvo.peluchitos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_inventory.view.*



class InventoryFragment : Fragment() {
    private var lista =arrayListOf<PeluchesClass>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_inventory, container, false)
        if (arguments != null) {
            lista = arguments!!.getParcelableArrayList<PeluchesClass>("lista") as ArrayList<PeluchesClass>
        }


        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        val superheroesAdapter = context?.let { PeluchitosAdapter(lista, it) }
        recyclerView.adapter = superheroesAdapter




        return view
    }





}
