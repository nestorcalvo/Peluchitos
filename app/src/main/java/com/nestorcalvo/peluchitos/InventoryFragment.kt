package com.nestorcalvo.peluchitos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_inventory.view.*



class InventoryFragment : Fragment() {
    private var lista =arrayListOf<PeluchesClass>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_inventory, container, false)
        if (arguments != null) {
            lista = arguments!!.getParcelableArrayList<PeluchesClass>("lista") as ArrayList<PeluchesClass>
        }
        view.tvNombreInventario.text = lista.size.toString()
        return view
    }


}
