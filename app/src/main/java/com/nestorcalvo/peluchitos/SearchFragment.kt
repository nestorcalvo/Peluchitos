package com.nestorcalvo.peluchitos


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_delete.view.*
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment() {
    private var lista = arrayListOf<PeluchesClass>()
    private var listafound = arrayListOf<PeluchesClass>()
    private var NotFound:Boolean = true
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_search, container, false)

        view.bnSearch.setOnClickListener {
            listafound.clear()
            if (arguments != null) {
                lista = arguments!!.getParcelableArrayList<PeluchesClass>("lista") as ArrayList<PeluchesClass>
            }
            var buscar = view.edNombreSearch.text.toString()
            for (index in 0 until lista.size step 1) {



                if (lista[index].nombre == buscar) {

                    listafound.add(lista[index])
                    NotFound = false
                }

            }

            if (NotFound) {
                Toast.makeText(context, "No se encontró ningun peluche con ese nombre", Toast.LENGTH_SHORT).show()
            }
            else{view.edNombreSearch.setText("")
                recyclerView = view.findViewById(R.id.recycler)
                recyclerView.setHasFixedSize(true)

                recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

                val superheroesAdapter = context?.let { PeluchitosAdapter(listafound, it) }
                recyclerView.adapter = superheroesAdapter

            }
        }


        return view
    }


}
