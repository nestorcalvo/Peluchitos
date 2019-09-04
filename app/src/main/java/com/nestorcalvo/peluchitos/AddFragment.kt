package com.nestorcalvo.peluchitos


import android.content.Context
import android.os.Build
import android.os.Build.ID
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add.view.*
import java.lang.ClassCastException
import java.lang.NumberFormatException


class AddFragment : Fragment() {
    var interfaz: comunicador? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.bnAdd.setOnClickListener {
            try{
                val ID = view.edID.text.toString()
                val nombre = view.edNombre.text.toString()
                val cantidad = view.edCantidad.text.toString().toInt()
                val precio = view.edPrecio.text.toString().toInt()
                val empty = ""

                interfaz?.guardarDatos(ID, nombre, cantidad, precio)
                Toast.makeText(context, R.string.add_success, Toast.LENGTH_SHORT).show()
                view.edID.setText(empty)
                view.edNombre.setText(empty)
                view.edCantidad.setText(empty)
                view.edPrecio.setText(empty)
            }
            catch (e:NumberFormatException){
                Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show()

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
