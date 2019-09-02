package com.nestorcalvo.peluchitos


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add.view.*
import java.lang.ClassCastException


class AddFragment : Fragment() {
    var interfaz: comunicador ?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.bnAdd.setOnClickListener {

            val ID:String = view.edID.text.toString()
            val nombre:String = view.edNombre.text.toString()
            val cantidad:Int = view.edCantidad.text.toString().toInt()
            val precio:Int = view.edPrecio.text.toString().toInt()
            interfaz?.guardarDatos(ID,nombre,cantidad,precio)

        }
        return view
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            interfaz = context!! as comunicador
        } catch (e : ClassCastException){
            Log.d("exception",e.toString())

        }
    }



}
