package com.nestorcalvo.peluchitos


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_delete.view.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import java.lang.ClassCastException


class DeleteFragment : Fragment(){
    var lista = arrayListOf<PeluchesClass>()
    var interfaz: comunicador? = null
    private var NotFound:Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_delete, container, false)
        view.bnDelete.setOnClickListener{
            if (arguments != null) {
                lista = arguments!!.getParcelableArrayList<PeluchesClass>("lista") as ArrayList<PeluchesClass>
            }
            val buscar = view.edNombreDelete.text.toString()

            for (index in 0 until lista.size step 1) {
                if (lista[index].nombre == buscar){
                    Toast.makeText(context,"Su peluche ha sido eliminado exitosamente", Toast.LENGTH_LONG).show()
                    interfaz?.removerDatos(index)
                    NotFound = false
                    view.edNombreDelete.setText("")
                    break
                }
            }

            if (NotFound) {
                Toast.makeText(context, "No se encontró ningun peluche con ese nombre", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            interfaz = context!! as comunicador
        } catch (e: ClassCastException) {
            Log.d("exception", e.toString())

        }
    }

}
